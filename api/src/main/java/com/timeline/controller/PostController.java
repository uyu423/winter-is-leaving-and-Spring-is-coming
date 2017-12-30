package com.timeline.controller;

import com.timeline.service.CommentService;
import com.timeline.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.nio.channels.FileChannel;
import java.util.Map;

@RestController
@RequestMapping(path="/post")
public class PostController extends Controller{
    @Autowired
    private PostService postService;

    @Autowired
    private CommentService commentService;

    @PostMapping
    public Map<String, Object> createPost (@RequestBody Map<String, Object> body) {
        try {
            return this.httpResponse(true, postService.create(
                    new Long((Integer)body.get("userId")),
                    (String)body.get("content")
            ));

        } catch (Exception error) {
            error.printStackTrace();
            return this.httpResponse(false, error.toString());
        }
    }

    @GetMapping(path = "/{postId}")
    public Map<String, Object> getPostById (@PathVariable("postId") Long postId) {
        try {
            return this.httpResponse(true, postService.find(postId));
        } catch (Exception error) {
            error.printStackTrace();
            return this.httpResponse(false, error.toString());
        }
    }

    @PutMapping(path = "/{postId}")
    public Map<String, Object> updatPostById (@PathVariable("postId") Long postId,
                                              @RequestBody  Map<String, Object> body) {
        try {
           return this.httpResponse(true, postService.update(postId, (String)body.get("content")));
        } catch (Exception error) {
            error.printStackTrace();
            return this.httpResponse(false, error.toString());
        }

    }

    @DeleteMapping(path = "/{postId}")
    public Map<String, Object> deletePostById (@PathVariable("postId") Long postId) {
        try {
            postService.delete(postId);
            return this.httpResponse(true, null);
        } catch (Exception error) {
            error.printStackTrace();
            return this.httpResponse(false, error.toString());
        }
    }
//
    @PostMapping(path = "/{postId}/comment")
    public Map<String, Object> createComment(@PathVariable("postId") Long postId,
                                             @RequestBody Map<String, Object> body) {
        try {
            return this.httpResponse(true, commentService.create(postId,
                    new Long((Integer)body.get("userId")),
                    (String)body.get("content")));
        } catch (Exception error) {
            error.printStackTrace();
            return this.httpResponse(false, error.toString());
        }
    }


    // TODO: Comment 도메인이 post에 종속될 필요가 있는가?
    @DeleteMapping(path = "/{postId}/comment/{commentId}")
    public Map<String, Object> deleteCommentById(@PathVariable("postId") Long postId,
                                                 @PathVariable("commentId") Long commentId) {
        try {
            commentService.delete(commentId);
            return this.httpResponse(true, null);
        } catch (Exception error) {
            error.printStackTrace();
            return this.httpResponse(false, error.toString());
        }
    }

}
