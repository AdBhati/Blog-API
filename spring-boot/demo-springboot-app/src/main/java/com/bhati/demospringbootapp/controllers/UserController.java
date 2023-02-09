package com.bhati.demospringbootapp.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bhati.demospringbootapp.models.State;
import com.bhati.demospringbootapp.models.User;
import com.bhati.demospringbootapp.services.UserService;

@RestController
@CrossOrigin
@RequestMapping("/users")
public class UserController {

    // private static final Integer Uid = null;
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public User createUser(@RequestBody User user) throws Exception {

        return userService.createUser(user);

    }

    @GetMapping
    public List<User> allUser() {
        return userService.findAllUsers();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Integer id) throws Exception {
        return userService.getUserById(id);
    }

    @PutMapping("/update/{id}")
    public State updatedata(@PathVariable Integer id, @RequestBody User user) throws Exception {

        return userService.updatedata(id, user);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteuser(@PathVariable Integer id, @RequestBody User user) throws Exception {
        userService.deleteuser(id, user);
    }
}
