package com.example.workflow.service.impl;

import com.example.workflow.model.DTO.PictureDTO;
import com.example.workflow.model.DTO.UserRegisterDTO;
import com.example.workflow.model.entity.PictureEntity;
import com.example.workflow.model.entity.UserEntity;
import com.example.workflow.model.entity.RoleEntity;
import com.example.workflow.model.entity.enums.RoleEnum;
import com.example.workflow.model.service.UserServiceModel;
import com.example.workflow.model.view.UserView;
import com.example.workflow.repository.UserRepository;
import com.example.workflow.repository.RoleRepository;
import com.example.workflow.service.CloudinaryService;
import com.example.workflow.service.PictureService;
import com.example.workflow.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {


    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PictureService pictureService;
    private final PasswordEncoder passwordEncoder;
    private final UserDetailsService workflowDetailService;
    private final CloudinaryService cloudinaryService;
    private final ModelMapper modelMapper;

    public UserServiceImpl(UserRepository userRepository,
                           RoleRepository roleRepository,
                           PictureService pictureService, PasswordEncoder passwordEncoder,
                           UserDetailsService workflowDetailService, CloudinaryService cloudinaryService, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.pictureService = pictureService;
        this.passwordEncoder = passwordEncoder;
        this.workflowDetailService = workflowDetailService;
        this.cloudinaryService = cloudinaryService;
        this.modelMapper = modelMapper;
    }

    @Override
    public void initializeAdmin() {
        if (userRepository.count() == 0) {
            RoleEntity adminRole = roleRepository.findByRole(RoleEnum.ADMIN);
            RoleEntity userRole = roleRepository.findByRole(RoleEnum.USER);

            UserEntity admin = new UserEntity();

            admin.setUsername("admin")
                    .setFirstName("admin")
                    .setLastName("admin")
                    .setEmail("admin@gmail.com")
                    .setPassword(passwordEncoder.encode("123456"))
                    .setRoles(Set.of(adminRole, userRole));
            userRepository.save(admin);

            UserEntity user = new UserEntity();

            user.setUsername("lyonova")
                    .setFirstName("Lora")
                    .setLastName("Yonova")
                    .setEmail("lor4eto111@gmail.com")
                    .setPassword(passwordEncoder.encode("123456"))
                    .setRoles(Set.of(userRole));

            userRepository.save(user);
        }
    }

    @Override
    public UserView findByUsername(String username) {
        UserEntity userEntity = userRepository.findUserEntityByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User not exists."));

        return modelMapper.map(userEntity, UserView.class);

//        return userRepository.findByUsername(username).map(userEntity -> {
//            UserView userView = new UserView();
//            userView.setUsername(userEntity.getUsername())
//                    .setId(userEntity.getId())
//                    .setFirstName(userEntity.getFirstName())
//                    .setLastName(userEntity.getLastName())
//                    .setEmail(userEntity.getEmail())
//                    .setPicture(userEntity.getPicture().getUrl());
//            return userView;
//        }).get();

    }

    @Override
    public void addProfilePicture(String name, PictureDTO pictureDTO) throws IOException {
        UserEntity userEntity = userRepository.findByUsername(name).orElseThrow(() -> new UsernameNotFoundException("User not found."));

        PictureEntity pictureEntity = pictureService.createPictureEntity(pictureDTO.getPicture());

        pictureService.savePicture(pictureEntity);
        userEntity.setPicture(pictureEntity);
        userRepository.save(userEntity);

    }

    @Override
    public void updateProfile(UserServiceModel userServiceModel, String email) {

        UserEntity userEntity = userRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("User with email " + email + "not exists."));

        userEntity.setFirstName(userServiceModel.getFirstName())
                .setLastName(userServiceModel.getLastName())
                .setEmail(userServiceModel.getEmail());

        userRepository.save(userEntity);

    }

    @Override
    public UserServiceModel findUser(String username) {
        return userRepository
                .findByUsername(username)
                .map(userEntity -> modelMapper.map(userEntity, UserServiceModel.class))
                .orElseThrow(() -> new UsernameNotFoundException("User with username " + username + " not exists."));

    }

    @Override
    public void deletePicture(String name) {
        UserEntity userEntity = userRepository.findByUsername(name).orElseThrow(() -> new UsernameNotFoundException("User not found."));

        cloudinaryService.delete(userEntity.getPicture().getPublicId());
        String publicId = userEntity.getPicture().getPublicId();
        pictureService.delete(publicId);
        userEntity.setPicture(null);
        userRepository.save(userEntity);

    }


    @Override
    public void registerAndLoginUser(UserRegisterDTO userRegisterDTO) {
        UserEntity userEntity = new UserEntity()
                .setUsername(userRegisterDTO.getUsername())
                .setFirstName(userRegisterDTO.getFirstName())
                .setLastName(userRegisterDTO.getLastName())
                .setEmail(userRegisterDTO.getEmail())
                .setPassword(passwordEncoder.encode(userRegisterDTO.getPassword()))
                .setRoles(Set.of(roleRepository.findByRole(RoleEnum.USER)));

        userRepository.save(userEntity);

        UserDetails userDetails = workflowDetailService.loadUserByUsername(userEntity.getUsername());

        Authentication authentication = new UsernamePasswordAuthenticationToken(
                userDetails.getUsername(),
                userDetails.getPassword(),
                userDetails.getAuthorities()
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

    }


}
