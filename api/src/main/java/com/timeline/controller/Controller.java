package com.timeline.controller;

import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

public class Controller {
    Map<String, Object> httpResponse(Boolean success, Object data) {
        Map<String, Object> response = new HashMap<String, Object>();
        response.put("success", success);
        response.put("data", data);

        return response;
    }
}
