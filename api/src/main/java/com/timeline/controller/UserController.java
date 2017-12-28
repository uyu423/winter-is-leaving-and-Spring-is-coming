package com.timeline.controller;

import com.timeline.domain.User;
import com.timeline.domain.UserFollowRelation;
import com.timeline.repository.UserFollowRelationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.timeline.repository.UserRepository;

@RestController
@RequestMapping(path="/user")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserFollowRelationRepository followRepository;

    @PostMapping
    public User createUser (@RequestBody User newUser) {
        userRepository.save(newUser);
        return newUser;
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable("id") Long userId) {
        return userRepository.findOne(userId);
    }

    @GetMapping
    public Iterable<User> getUserAll() {
        return userRepository.findAll();
    }

    @PostMapping(path="/follow")
    public UserFollowRelation followUser (@RequestBody UserFollowRelation newFollow) {
       followRepository.save(newFollow);

       return newFollow;
    }

    @GetMapping(path="/{id}/follow")
    public Iterable<UserFollowRelation> getFollowingUsers (@PathVariable("id") Long userId) {
        return followRepository.findByUserId(userId);
    }

    @GetMapping(path="/{id}/follower")
    public Iterable<UserFollowRelation> getFollowers (@PathVariable("id") Long followUserId) {
        return followRepository.findByFollowUserId(followUserId);
    }
}
