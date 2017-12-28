package com.timeline.service;

import com.timeline.domain.FollowRelation;
import com.timeline.domain.User;
import com.timeline.repository.FollowRelationRepository;
import com.timeline.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

// TODO: I think there is a way to reduce all duplicate service codes.
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private FollowRelationRepository followRepository;

    public User find(Long userId) throws Exception {
        if (userId == null) throw new Exception("userId is Required");
        return userRepository.findOne(userId);
    }

    public User create(String email, String name) throws Exception {
        if (email == null) throw new Exception("email is Required");
        User user = new User(email, name, new Date());
        // 본인의 포스트도 타임라인에 띄워주기 위해 셀프 등록
        userRepository.save(user);
        followRepository.save(new FollowRelation(user, user, new Date()));
        return user;
    }

    public User update(Long userId, String name) throws Exception {
        if (userId == null) throw new Exception("userId is Required");
        User user = userRepository.findOne(userId);
        if (name != null) {
            user.setName(name);
        }
        user.setUpdatedAt(new Date());
        return userRepository.save(user);
    }

    public void delete(Long userId) throws Exception {
        if (userId == null) throw new Exception("userId is Required");
        User user = userRepository.findOne(userId);
        if (user == null) throw new Exception("not found user");
        userRepository.delete(user);
    }
}
