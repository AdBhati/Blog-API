package com.bhati.blogapi.controller;

import com.bhati.blogapi.dto.ProfileDto;
import com.bhati.blogapi.service.MappingService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import com.bhati.blogapi.dto.SignupRequest;
import com.bhati.blogapi.model.AuthenticationRequest;
import com.bhati.blogapi.model.AuthenticationResponse;
import com.bhati.blogapi.model.User;
import com.bhati.blogapi.repository.UserRepository;
import com.bhati.blogapi.service.AuthService;
import com.bhati.blogapi.service.CustomUserDetailsService;
import com.bhati.blogapi.service.PostService;
import com.bhati.blogapi.util.JwtUtils;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@RestController
@CrossOrigin
public class AuthController {

        private final UserRepository userRepository;
        private final JwtUtils jwtUtils;
        private final AuthenticationManager authenticationManager;
        private final CustomUserDetailsService customUserDetailsService;
        private final AuthService authService;
        private final PostService postService;

        private final MappingService mappingService;


        public AuthController(UserRepository userRepository, JwtUtils jwtUtils, AuthenticationManager authenticationManager, CustomUserDetailsService customUserDetailsService, AuthService authService, PostService postService, MappingService mappingService) {
                this.userRepository = userRepository;
                this.jwtUtils = jwtUtils;
                this.authenticationManager = authenticationManager;
                this.customUserDetailsService = customUserDetailsService;
                this.authService = authService;
                this.postService = postService;
                this.mappingService = mappingService;
        }

        /* LOGIN */
        @PostMapping("/authenticate")
        public AuthenticationResponse createAuthenticationToken(
                        @RequestBody AuthenticationRequest request) throws Exception {
                log.info("=====Authenticate=====");

                User user = userRepository
                                .findByEmail(request.getUsername())
                                .orElse(null);
                try {
                        authenticationManager.authenticate(
                                        new UsernamePasswordAuthenticationToken(
                                                        request.getUsername(),
                                                        request.getPassword()));
                } catch (Exception ex) {
                        ex.printStackTrace();
                        throw new UsernameNotFoundException("exception");
                }
                final UserDetails userDetails = customUserDetailsService.loadUserByUsername(
                                request.getUsername());
                final String jwt = jwtUtils.generateToken(userDetails);

                return new AuthenticationResponse(
                                jwt,
                                "users",
                                user.getId(),
                                200,
                                "",
                                true);
        }
        @PostMapping("/signup")
        public AuthenticationResponse signUp(@RequestBody SignupRequest signupRequest) {
                return authService.create(signupRequest);
        }



}
