package com.timeline.service;

import com.timeline.domain.Post;
import com.timeline.domain.User;
import com.timeline.repository.PostRepository;
import com.timeline.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;

    public Post find(Long postId) throws Exception {
        if (postId == null) throw new Exception("postId is Required");
        return postRepository.findOne(postId);
    }

    public Post create(Long userId, String content) throws Exception {
        if (userId == null) throw new Exception("userId is Required");

        User user = userRepository.findOne(userId);
        if (user == null) throw new Exception("user is null");

        Post post = new Post(user, content, new Date());
        postRepository.save(post);

        return post;
    }

    public Post update(Long postId, String content) throws Exception {
        if (postId == null) throw new Exception("postId is Required");
        Post post = postRepository.findOne(postId);

        if (content != null) {
            post.setContent(content);
        }
        post.setUpdatedAt(new Date());

        return postRepository.save(post);
    }

    public void delete(Long postId) throws Exception {
        if (postId == null) throw new Exception("postId is Required");
        Post post = postRepository.findOne(postId);
        if (post == null) throw new Exception("not found post");
        postRepository.delete(post);
    }

}
