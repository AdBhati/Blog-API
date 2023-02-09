package com.bhati.demospringbootapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bhati.demospringbootapp.models.AuthenticationRequest;
import com.bhati.demospringbootapp.models.AuthenticationResponse;

@RestController
public class MainUserController {

    @Autowired
    private final AuthenticationManager authenticationManager;

    @GetMapping("/hello")
    public String hello() {
        return "hello World";
    }

    @PostMapping("/authenticate")
    public AuthenticationResponse createAuthenticationToken(
            @RequestBody AuthenticationRequest request) throws Exception {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        AuthenticationRequest.getUsername(),
                        AuthenticationRequest.getPassword()));

    }

}
