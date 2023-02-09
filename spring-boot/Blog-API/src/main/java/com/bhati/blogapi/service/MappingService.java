package com.bhati.blogapi.service;
import com.bhati.blogapi.dto.ProfileDto;
import com.bhati.blogapi.dto.UserDto;
import com.bhati.blogapi.model.Address;
import com.bhati.blogapi.model.User;
import com.bhati.blogapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MappingService {

    @Autowired
    private UserRepository userRepository;

    public List<UserDto> getProfile(){
         return ((List<User>) userRepository
                 .findAll())
                 .stream()
                 .map(this::convertDataIntoDTO)
                 .collect(Collectors.toList());
    }
        private UserDto convertDataIntoDTO (User userData){


            UserDto dto = new UserDto();

        dto.setFirstName(userData.getFirstName());
        dto.setLastName(userData.getLastName());
        dto.setEmail(userData.getEmail());
        dto.setDob(userData.getDob());

             //  Address add = userData.getAddress();
            //   add.setCity(userData.getAddress().getCity());

        return dto;
    }
}
