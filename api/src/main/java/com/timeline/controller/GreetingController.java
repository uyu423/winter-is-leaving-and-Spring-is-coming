package com.timeline.controller;

import java.util.concurrent.atomic.AtomicLong;

import com.timeline.domain.Greeting;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                String.format(template, name));
    }

    @RequestMapping("/adder")
    public int adder (
            @RequestParam(value="num1", defaultValue="0") int num1,
            @RequestParam(value="num2", defaultValue="0") int num2) {
        return num1 + num2;
    }
}