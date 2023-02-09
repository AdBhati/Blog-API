package com.bhati.blogapi.dto;

import com.bhati.blogapi.model.Address;
import com.bhati.blogapi.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PostDto {

    private UUID id;

    private UserDto userDto;

    private Address address;


}
