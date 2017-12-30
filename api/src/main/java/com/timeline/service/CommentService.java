package com.timeline.service;

import com.timeline.domain.Post;
import com.timeline.domain.User;
import com.timeline.domain.Comment;
import com.timeline.repository.CommentRepository;
import com.timeline.repository.PostRepository;
import com.timeline.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Date;

@Service
public class CommentService {
    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CommentRepository commentRepository;

    public Comment create(Long postId, Long userId, String content) throws Exception {
        if (postId == null) throw new Exception("postId Required");
        if (userId == null) throw new Exception("userId Required");

        Post post = postRepository.findOne(postId);
        if (post == null) throw new Exception("not found post");

                User user = userRepository.findOne(userId);
        if (user == null) throw new Exception("not found user");

        Comment comment = new Comment(post.getId(), user, content, new Date());

        return commentRepository.save(comment);
    }

    public void delete(Long commentId) throws Exception {
        if (commentId == null) throw new Exception("commentId is Required");
        Comment comment = commentRepository.findOne(commentId);
        if (comment == null) throw new Exception("not found comment");
        commentRepository.delete(comment);
    }

}
