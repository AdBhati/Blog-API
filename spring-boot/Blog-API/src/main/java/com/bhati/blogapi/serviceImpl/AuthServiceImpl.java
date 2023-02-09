package com.bhati.blogapi.serviceImpl;

import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.bhati.blogapi.dto.SignupRequest;
import com.bhati.blogapi.model.AuthenticationResponse;
import com.bhati.blogapi.model.User;
import com.bhati.blogapi.repository.UserRepository;
import com.bhati.blogapi.service.AuthService;
import com.bhati.blogapi.util.JwtUtils;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final JwtUtils jwtUtils;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final ModelMapper modelMapper;



    public AuthServiceImpl(UserRepository userRepository, JwtUtils jwtUtils,
            BCryptPasswordEncoder bCryptPasswordEncoder, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.jwtUtils = jwtUtils;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.modelMapper = modelMapper;
    }

    @Override
    public AuthenticationResponse create(SignupRequest signupRequest) {
        User existingUser = userRepository.findByEmail(signupRequest.getEmail()).orElse(null);
        if (existingUser != null) {
            throw new UsernameNotFoundException("User Already Exists");
        }
        signupRequest.setPassword(bCryptPasswordEncoder.encode(signupRequest.getPassword()));
        User newUser = modelMapper.map(signupRequest, User.class);
        newUser.setIsActive(true);
        userRepository.save(newUser);
        AuthenticationResponse response = new AuthenticationResponse(null, "Users", newUser.getId(), 201, "", true);

        return response;
    }
}
