package com.example.workflow.service.impl;

import com.example.workflow.model.user.UserDetail;
import com.example.workflow.model.entity.UserEntity;
import com.example.workflow.model.entity.RoleEntity;
import com.example.workflow.repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UsersDetailService implements UserDetailsService {

    private final UserRepository userRepository;

    public UsersDetailService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository
                .findByUsername(username)
                .map(this::map)
                .orElseThrow(() -> new UsernameNotFoundException("User with name " + username + " not found"));

    }

    private UserDetails map(UserEntity userEntity) {
        return new UserDetail(
                userEntity.getId(),
                userEntity.getUsername(),
                userEntity.getFirstName(),
                userEntity.getLastName(),
                userEntity.getEmail(),
                userEntity.getPassword(),
                userEntity.getRoles()
                        .stream()
                        .map(this::map)
                        .toList()
        );
    }

    private GrantedAuthority map(RoleEntity role) {
        return new SimpleGrantedAuthority("ROLE_" +
                role.getRole().name());
    }
}
