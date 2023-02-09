package com.bhati.blogapi.model;

import java.util.UUID;

import lombok.Data;

@Data
public class AuthenticationResponse {

    private final String jwt;
    private String objectName;
    private UUID id;
    private int statusCodeValue;
    private String message;
    private Boolean success;

    public AuthenticationResponse(String jwt) {
        this.jwt = jwt;
    }

    public AuthenticationResponse(
            String jwt,
            String objectName,
            UUID id,
            int statusCodeValue,
            String message,
            Boolean success) {
        super();
        this.jwt = jwt;
        this.objectName = objectName;
        this.id = id;
        this.statusCodeValue = statusCodeValue;
        this.message = message;
        this.success = success;
    }
}
