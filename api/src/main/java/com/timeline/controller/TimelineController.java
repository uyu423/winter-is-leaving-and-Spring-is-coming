package com.timeline.controller;

import com.timeline.repository.PostRepository;
import com.timeline.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping
public class TimelineController extends Controller {
    @Autowired
    private PostService postService;

    @GetMapping
    public Map<String, Object> getTimeline (@RequestParam("userId") Long userId) {
        try {
            return this.httpResponse(true, postService.findForTimeline(userId));
        } catch (Exception error) {
            error.printStackTrace();
            return this.httpResponse(false, error.toString());
        }
    }
}
