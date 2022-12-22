package com.example.workflow.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class MyProfileController {

    @GetMapping("/profile")
    public String profile() {
        return "my_profile";
    }
}
