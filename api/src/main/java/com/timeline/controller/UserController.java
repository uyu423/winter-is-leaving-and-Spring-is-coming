package com.timeline.controller;

import com.timeline.domain.User;
import com.timeline.repository.UserRepository;
import com.timeline.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping(path="/user")
public class UserController extends Controller{
    @Autowired
    private UserService userService;

    @PostMapping
    public Map<String, Object> createUser (@RequestBody Map<String, Object> body) {
        try {
           return this.httpResponse(true, userService.create(
                   (String)body.get("email"),
                   (String)body.get("name")
           ));
        } catch (Exception error) {
            error.printStackTrace();
            return this.httpResponse(false, error.toString());
        }
    }

    @GetMapping(path = "/{userId}")
    public Map<String, Object> getUserById (@PathVariable Long userId) {
        try {
            return this.httpResponse(true, userService.find(userId));
        } catch (Exception error) {
            error.printStackTrace();
            return this.httpResponse(false, error.toString());
        }
    }

    @PutMapping(path = "/{userId}")
    public Map<String, Object> updateUserById (@PathVariable Long userId,
                                               @RequestBody Map<String, Object> body) {
        try {
            return this.httpResponse(true, userService.update(userId, (String)body.get("name")));
        } catch (Exception error) {
            error.printStackTrace();
            return this.httpResponse(false, error.toString());
        }
    }

    @DeleteMapping(path = "/{userId}")
    public Map<String, Object> deleteUserById (@PathVariable Long userId) {
        try {
            userService.delete(userId);
            return this.httpResponse(true, null);
        } catch (Exception error) {
            error.printStackTrace();
            return this.httpResponse(false, error.toString());
        }
    }
}
