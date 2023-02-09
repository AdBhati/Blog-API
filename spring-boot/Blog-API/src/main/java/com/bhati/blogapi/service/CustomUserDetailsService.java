package com.bhati.blogapi.service;

import java.util.Optional;

import com.bhati.blogapi.dto.ProfileDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.bhati.blogapi.model.CustomUserDetails;
import com.bhati.blogapi.model.User;
import com.bhati.blogapi.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;



    @Override
    public CustomUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("======CustomUserDetailsService======");

        Optional<User> user = userRepository.findByEmail(username);
        User users = user.get();
        if (user == null) {
            throw new UsernameNotFoundException("User not found with username : " + username);
        }
        return new CustomUserDetails(users);
    }



}