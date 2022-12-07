package com.example.workflow.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/companies")
public class LoginController {

    @GetMapping("/login")
    public String login() {
        return "login";
    }
}