package com.example.workflow.web;

import com.example.workflow.model.DTO.UserRegisterDTO;
import com.example.workflow.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class RegisterController {

    private final UserService userService;

    public RegisterController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @ModelAttribute("userRegisterDTO")
    public UserRegisterDTO userRegisterDTO() {
        return new UserRegisterDTO();
    }

    @PostMapping("/register")
    public String confirmRegister(@Valid UserRegisterDTO userRegisterDTO,
                                  BindingResult bindingResult,
                                  RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors() || !userRegisterDTO.getPassword().equals(userRegisterDTO.getConfirmPassword())) {
            redirectAttributes.addFlashAttribute("userRegisterDTO", userRegisterDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userRegisterDTO", bindingResult);

            return "/register";
        }

        userService.registerAndLoginUser(userRegisterDTO);
        return "redirect:/";
    }
}
