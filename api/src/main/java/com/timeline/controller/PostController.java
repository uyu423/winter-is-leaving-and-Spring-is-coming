package com.timeline.controller;

import com.timeline.domain.Post;
import com.timeline.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Stream;


@RestController
@RequestMapping(path="/post")
public class PostController {
    @Autowired
    private PostRepository repository;

//    @RequestMapping(method = RequestMethod.POST)
    @PostMapping
    public Post createPost(@RequestBody Post newPost) {
        repository.save(newPost);

        return newPost;
    }

    @GetMapping(path="/{id}")
    public Post getPostById(@PathVariable("id") Long postId) {
        Post post = repository.findOne(postId);

        return post;
    }

    @GetMapping
    public Iterable<Post> getPostByUserId(@RequestParam Long userId) {
        return repository.findByUserId(userId);
    }
}
