package com.taomish.applicationtwo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/application-two")
public class SecondController {
    @GetMapping("/hello")
    public String hello() {
        return "Hello World 2";
    }
}
