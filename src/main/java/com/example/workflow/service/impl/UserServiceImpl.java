package com.example.workflow.service.impl;

import com.example.workflow.model.DTO.UserRegisterDTO;
import com.example.workflow.model.entity.UserEntity;
import com.example.workflow.model.entity.RoleEntity;
import com.example.workflow.model.entity.enums.RoleEnum;
import com.example.workflow.repository.UserRepository;
import com.example.workflow.repository.RoleRepository;
import com.example.workflow.service.UserService;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserDetailsService workflowDetailService;

    public UserServiceImpl(UserRepository userRepository,
                           RoleRepository roleRepository,
                           PasswordEncoder passwordEncoder,
                           UserDetailsService workflowDetailService) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.workflowDetailService = workflowDetailService;
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
