package com.example.workflow.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class TaskController {

    @GetMapping("/tasks")
    public String tasks() {
        return "my_task";
    }
}
