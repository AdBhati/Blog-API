package com.bhati.blogapi.dto;

import com.bhati.blogapi.model.Post;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfileDto {


    private String firstName;
    private String lastName;
    private String email;
    private String dob;
   private String city;

//    private Post post;


}
