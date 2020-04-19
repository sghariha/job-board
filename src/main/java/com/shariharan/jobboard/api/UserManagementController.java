package com.shariharan.jobboard.api;

import com.shariharan.jobboard.api.response_objects.LoginResponse;
import com.shariharan.jobboard.auth.AuthUserInfo;
import com.shariharan.jobboard.auth.IDParser;
import com.shariharan.jobboard.auth.TokenUtil;
import com.shariharan.jobboard.db.PosterUserRepository;
import com.shariharan.jobboard.db.SeekerUserRepository;
import com.shariharan.jobboard.error_handlers.UserNotFoundByIDException;
import com.shariharan.jobboard.model.user.PosterUser;
import com.shariharan.jobboard.model.user.SeekerUser;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Criteria;

@RestController
@RequestMapping("/api/userManagement")
public class UserManagementController {
    @Autowired
    private final SeekerUserRepository seekerUserRepository;

    @Autowired
    private final PosterUserRepository posterUserRepository;

    @Autowired
    IDParser idp;

    public UserManagementController(
        SeekerUserRepository seekerUserRepository,
        PosterUserRepository posterUserRepository
    ) {
        this.seekerUserRepository = seekerUserRepository;
        this.posterUserRepository = posterUserRepository;
    }

    @PostMapping("seekerUser/login")
    @ResponseBody
    public LoginResponse loginSeekerUser(@RequestBody AuthUserInfo authUserInfo) {
    	List<SeekerUser> users = seekerUserRepository.findByEmail(authUserInfo.getEmail());
    	if (users.size() == 0) {
            return new LoginResponse(null, "Invalid email");
        }
        else {
            if (!(users.get(0).getPassword().equals(authUserInfo.getPassword()))) {
                return new LoginResponse(null, "Invalid password");
            }
            else {
                String token = null;

                try {
                    token = TokenUtil.createToken(
                        authUserInfo.getEmail(), 
                        idp.getId(authUserInfo.getUserType(), authUserInfo.getEmail()), 
                        "s"
                    );
                }
                catch (UserNotFoundByIDException e) {
                    return new LoginResponse(null, "User not found in system");
                }

                return new LoginResponse(token, "Successful login");
            }
        }
    }

    @PostMapping("posterUser/login")
    @ResponseBody
    public LoginResponse loginPosterUser(@RequestBody AuthUserInfo authUserInfo) {
    	List<PosterUser> users = posterUserRepository.findByEmail(authUserInfo.getEmail());
    	if (users.size() == 0) {
            return new LoginResponse(null, "Invalid email");
        }
        else {
            if (!(users.get(0).getPassword().equals(authUserInfo.getPassword()))) {
                return new LoginResponse(null, "Invalid password");
            }
            else {
                String token = null;

                try {
                    IDParser idp = new IDParser();
                    token = TokenUtil.createToken(
                        authUserInfo.getEmail(), 
                        idp.getId(authUserInfo.getUserType(), authUserInfo.getEmail()), 
                        "p"
                    );
                }
                catch (UserNotFoundByIDException e) {
                    return new LoginResponse(null, "User not found in system");
                }

                return new LoginResponse(token, "Successful login");
            }
        }
    }
}