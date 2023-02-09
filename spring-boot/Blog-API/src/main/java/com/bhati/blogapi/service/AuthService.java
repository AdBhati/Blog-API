package com.bhati.blogapi.service;

import com.bhati.blogapi.dto.SignupRequest;
import com.bhati.blogapi.model.AuthenticationResponse;

public interface AuthService {
    AuthenticationResponse create(SignupRequest signupRequest);


}
