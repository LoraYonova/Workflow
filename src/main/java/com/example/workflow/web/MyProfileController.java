package com.example.workflow.web;

import com.example.workflow.model.DTO.UserUpdateProfileDTO;
import com.example.workflow.model.entity.PictureEntity;
import com.example.workflow.model.service.UserServiceModel;
import com.example.workflow.model.view.UserView;
import com.example.workflow.repository.PictureRepository;
import com.example.workflow.service.CloudinaryService;
import com.example.workflow.service.UserService;
import com.example.workflow.service.impl.CloudinaryImage;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.io.IOException;
import java.security.Principal;

@Controller
@RequestMapping("/users")
public class MyProfileController {

    private final UserService userService;
    private final CloudinaryService cloudinaryService;
    private final PictureRepository pictureRepository;
    private final ModelMapper modelMapper;


    public MyProfileController(UserService userService, CloudinaryService cloudinaryService, PictureRepository pictureRepository, ModelMapper modelMapper) {
        this.userService = userService;
        this.cloudinaryService = cloudinaryService;
        this.pictureRepository = pictureRepository;
        this.modelMapper = modelMapper;
    }


    @GetMapping("/profile")
    public String userProfileView(Principal principal, Model model) {
        model.addAttribute("profile", userService.findByUsername(principal.getName()));

        return "my_profile";
    }

    @GetMapping("/profile/update")
    public String profileUpdate(Principal principal, Model model) {
        model.addAttribute("profile", userService.findByUsername(principal.getName()));
        return "profile_update";
    }

    @PostMapping("/profile/update")
    public String profileEdit(@Valid UserUpdateProfileDTO userUpdateProfileDTO, BindingResult bindingResult,
                              RedirectAttributes redirectAttributes, Principal principal) {

        UserView username = userService.findByUsername(principal.getName());

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("userUpdateProfileDTO", userUpdateProfileDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userUpdateProfileDTO", bindingResult);

            return "redirect:/profile/update";
        }

        userService.updateProfile(modelMapper.map(userUpdateProfileDTO, UserServiceModel.class), username.getUsername());

        return "redirect:/profile";
    }



    private PictureEntity createPictureEntity(MultipartFile file) throws IOException {
        CloudinaryImage upload = cloudinaryService.upload(file);
        return new PictureEntity()
                .setPublicId(upload.getPublicId())
                .setUrl(upload.getUrl());

    }

    @ModelAttribute
    public UserUpdateProfileDTO userUpdateProfileDTO() {
        return new UserUpdateProfileDTO();
    }




}
