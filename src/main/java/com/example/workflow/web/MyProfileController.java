package com.example.workflow.web;

import com.example.workflow.model.DTO.PictureDTO;
import com.example.workflow.model.DTO.UserUpdateProfileDTO;
import com.example.workflow.model.service.UserServiceModel;
import com.example.workflow.repository.PictureRepository;
import com.example.workflow.service.CloudinaryService;
import com.example.workflow.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.io.IOException;
import java.security.Principal;

@Controller
@RequestMapping("/users")
public class MyProfileController {

    private final UserService userService;
    private final ModelMapper modelMapper;


    public MyProfileController(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
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

        UserServiceModel user = userService.findUser(principal.getName());

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("userUpdateProfileDTO", userUpdateProfileDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userUpdateProfileDTO", bindingResult);

            return "redirect:/profile/update";
        }

        userService.updateProfile(modelMapper.map(userUpdateProfileDTO, UserServiceModel.class), user.getEmail());

        return "redirect:/users/profile/";
    }


    @PostMapping("/profile/update/picture")
    public String updatePicture(@Valid PictureDTO pictureDTO, RedirectAttributes redirectAttributes, Principal principal) throws IOException {

        if (pictureDTO.getPicture().isEmpty()) {
            redirectAttributes.addFlashAttribute("error", "Please select a picture!");

            return "redirect:";
        }

        userService.addProfilePicture(principal.getName(), pictureDTO);

        return "redirect:/users/profile/";
    }

//    private PictureEntity createPictureEntity(MultipartFile file) throws IOException {
//        CloudinaryImage upload = cloudinaryService.upload(file);
//        return new PictureEntity()
//                .setPublicId(upload.getPublicId())
//                .setUrl(upload.getUrl());
//
//    }

    @Transactional
    @GetMapping("/profile/update/picture/delete")
    public String deletePicture(Principal principal) {
        userService.deletePicture(principal.getName());
        return "redirect:/users/profile/";
    }

    @ModelAttribute
    public UserUpdateProfileDTO userUpdateProfileDTO() {
        return new UserUpdateProfileDTO();
    }

    @ModelAttribute
    public PictureDTO pictureDTO() {
        return new PictureDTO();
    }




}
