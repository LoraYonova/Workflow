package com.example.workflow.web;

import com.example.workflow.model.DTO.PictureDTO;
import com.example.workflow.model.entity.PictureEntity;
import com.example.workflow.repository.PictureRepository;
import com.example.workflow.service.CloudinaryService;
import com.example.workflow.service.UserService;
import com.example.workflow.service.impl.CloudinaryImage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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


    public MyProfileController(UserService userService, CloudinaryService cloudinaryService, PictureRepository pictureRepository) {
        this.userService = userService;
        this.cloudinaryService = cloudinaryService;
        this.pictureRepository = pictureRepository;
    }


    @GetMapping("/profile")
    public String userProfileView(Principal principal, Model model) {
        model.addAttribute("profile", userService.findByUsername(principal.getName()));

        return "my_profile";
    }

    @GetMapping("/profile/add")
    public String addPicture() {
        return "my_profile";
    }


    @PostMapping("/profile/add")
    public String addPicture(@Valid PictureDTO pictureDTO, RedirectAttributes redirectAttributes, Principal principal) throws IOException {

        if (pictureDTO.getPicture().isEmpty()) {
            redirectAttributes.addFlashAttribute("error", "Please select a picture");
            return "redirect:";
        }

        userService.addProfilePicture(principal.getName(), pictureDTO);


        return "redirect:/users/profile";
    }

    private PictureEntity createPictureEntity(MultipartFile file, String title) throws IOException {
        CloudinaryImage upload = cloudinaryService.upload(file);
        return new PictureEntity()
                .setPublicId(upload.getPublicId())
                .setUrl(upload.getUrl());

    }

    @ModelAttribute
    private PictureDTO pictureDTO() {
        return new PictureDTO();
    }


}
