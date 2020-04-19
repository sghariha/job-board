package com.shariharan.jobboard.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shariharan.jobboard.auth.AuthUserInfo;
import com.shariharan.jobboard.auth.TokenPayload;
import com.shariharan.jobboard.auth.TokenUtil;
import com.shariharan.jobboard.db.SeekerUserRepository;
import com.shariharan.jobboard.error_handlers.InvalidTokenException;
import com.shariharan.jobboard.model.user.SeekerUser;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/seekerUsers")
public class SeekerUserController {
    @Autowired
    private final SeekerUserRepository seekerUserRepository;

    public SeekerUserController(SeekerUserRepository seekerUserRepository) {
        this.seekerUserRepository = seekerUserRepository;
    }

    @GetMapping("/all")
    public ResponseEntity<List<SeekerUser>> getAllUsers(@RequestHeader("Authorization") String token) {
        try {
            TokenUtil.decodeToken(token);
        }
        catch (InvalidTokenException e) {
            return ResponseEntity.status(401).body(null);
        }
        return ResponseEntity.ok().body(this.seekerUserRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SeekerUser> getUserById(@RequestHeader("Authorization") String token, @PathVariable String id) {
        try {
            TokenUtil.decodeToken(token);
        }
        catch (InvalidTokenException e) {
            return ResponseEntity.status(401).body(null);
        }
        SeekerUser user = this.seekerUserRepository.findById(id).get();
        return ResponseEntity.ok().body(user);
    }

    @PostMapping("/new")
    public void addNewUser(@RequestBody SeekerUser seekerUser) {
        this.seekerUserRepository.insert(seekerUser);
    }

    @PutMapping("/{id}")
    public void updateUser(@RequestHeader("Authorization") String token, @PathVariable String id, @RequestBody SeekerUser seekerUser) {
        try {
            TokenUtil.decodeToken(token);
        }
        catch (InvalidTokenException e) {
            return;
        }
        SeekerUser user = this.seekerUserRepository.findById(id).get();
        user = seekerUser;
        this.seekerUserRepository.save(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUserById(@PathVariable String id) {
        this.seekerUserRepository.deleteById(id);
    }
}