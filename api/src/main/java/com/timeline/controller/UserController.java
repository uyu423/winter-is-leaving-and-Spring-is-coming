package com.timeline.controller;

import com.timeline.domain.User;
import com.timeline.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/user")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping
    public User createUser (@RequestBody User newUser) {
       return userRepository.save(newUser);
    }

    @GetMapping(path = "/{userId}")
    public User getUserById (@PathVariable Long userId) {
        return userRepository.findOne(userId);
    }

    @PutMapping(path = "/{userId}")
    public User updateUserById (@PathVariable Long userId, @RequestBody User user) {
        return new User();
    }

    @DeleteMapping(path = "/{userId}")
    public Boolean deleteUserById (@PathVariable Long userId) {
        return false;
    }
}
