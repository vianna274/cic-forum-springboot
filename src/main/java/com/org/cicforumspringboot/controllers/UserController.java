package com.org.cicforumspringboot.controllers;

import com.org.cicforumspringboot.models.User;
import com.org.cicforumspringboot.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/users")
    public Page<User> getUsers(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @GetMapping("/user/{userId}")
    public User getUser(@PathVariable String userId) {
        return userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found"));
}

    @GetMapping("/facebookUser/{faceId}")
    public User getFaceUser(@PathVariable String faceId) {
        return userRepository.findByFacebookUid(faceId).orElseThrow(() -> new ResourceNotFoundException("User not found"));
    }

    @PostMapping("/user")
    public User createUser(@Valid @RequestBody User user) {
        return userRepository.save(user);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping("/user/{userId}")
    public User updateUser(@PathVariable String userId,
                           @Valid @RequestBody User userRequest) {
        return userRepository
                .findById(userId)
                .map(user -> {
                    user.setFirstName(userRequest.getFirstName());
                    user.setLastName(userRequest.getLastName());
                    user.setPassword(userRequest.getPassword());
                    user.setUsername(userRequest.getUsername());
                    user.setPosts(userRequest.getPosts());
                    return userRepository.save(user);
                })
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
    }
}
