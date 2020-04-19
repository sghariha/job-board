package com.shariharan.jobboard.auth;

import java.util.List;

import com.shariharan.jobboard.db.PosterUserRepository;
import com.shariharan.jobboard.db.SeekerUserRepository;
import com.shariharan.jobboard.error_handlers.UserNotFoundByIDException;
import com.shariharan.jobboard.model.user.PosterUser;
import com.shariharan.jobboard.model.user.SeekerUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class IDParser {
    @Autowired
    private SeekerUserRepository seekerUserRepository;

    @Autowired
    private PosterUserRepository posterUserRepository;

    public String getId(String userType, String email) throws UserNotFoundByIDException {
        if (seekerUserRepository == null) System.out.println("null seeker repo");
        if (posterUserRepository == null) System.out.println("null poster repo");

        String id = null;

        switch (userType) {
            case "s":
                List<SeekerUser> seekerMatches = seekerUserRepository.findByEmail(email);
                if (seekerMatches.size() == 0) {
                    throw new UserNotFoundByIDException("No ID found for email: " + email);
                }
                id = seekerMatches.get(0).getId();
                break;
            case "p":
                List<PosterUser> posterMatches = posterUserRepository.findByEmail(email);
                if (posterMatches.size() == 0) {
                    throw new UserNotFoundByIDException("No ID found for email: " + email);
                }
                id = posterMatches.get(0).getId();
                break;
        }

        return id;
    }


}