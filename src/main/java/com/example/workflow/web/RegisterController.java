package com.example.workflow.web;

import com.example.workflow.service.CompanyService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/companies")
public class RegisterController {

    private final CompanyService companyService;

    public RegisterController(CompanyService companyService) {
        this.companyService = companyService;
    }


    @GetMapping("/register")
    public String register() {
        return "register";
    }
}
