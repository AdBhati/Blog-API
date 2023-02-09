package com.bhati.blogapi.dto;

import java.util.UUID;

import com.bhati.blogapi.model.Address;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private UUID id;

    private String email;

    private String firstName;

    private String lastName;
    private String dob;
    private Address address;
}
