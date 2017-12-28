package com.timeline.service;

import com.timeline.domain.FollowRelation;
import com.timeline.domain.User;
import com.timeline.repository.FollowRelationRepository;
import com.timeline.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Date;

// TODO: I think there is a way to reduce all duplicate service codes.
@Service
public class FollowRelationService {
    @Autowired
    private FollowRelationRepository followRelationRepository;

    @Autowired
    private UserRepository userRepository;

    public Collection<FollowRelation> findByUserId(Long userId) throws Exception {
       if (userId == null) throw new Exception("userId is Required");

       User user = userRepository.findOne(userId);
       if (user == null) throw new Exception("Not found User");

       return followRelationRepository.findByUser(user);
    }

    public FollowRelation create(Long userId, Long followUserId) throws Exception {
        FollowRelationService.validateUserIds(userId, followUserId);

        User user = userRepository.findOne(userId);
        if (user == null) throw new Exception("not found user");

        User followUser = userRepository.findOne(followUserId);
        if (followUser == null) throw new Exception("not found follow user");

        return followRelationRepository.save(new FollowRelation(user, followUser, new Date()));
    }


    public void delete(Long userId, Long followUserId) throws Exception {
        FollowRelationService.validateUserIds(userId, followUserId);

        User user = userRepository.findOne(userId);
        if (user == null) throw new Exception("not found user");

        User followUser = userRepository.findOne(followUserId);
        if (followUser == null) throw new Exception("not found follow user");

        FollowRelation follow = followRelationRepository.findByUserAndFollowUser(user, followUser);

        followRelationRepository.delete(follow);
    }

    static void validateUserIds(Long userId, Long followUserId) throws Exception {
        if (userId == null) throw new Exception("userId is Required");
        if (followUserId == null) throw new Exception("followUserId is Required");
        if (userId.equals(followUserId)) throw new Exception("can not same userIds");
    }
}
