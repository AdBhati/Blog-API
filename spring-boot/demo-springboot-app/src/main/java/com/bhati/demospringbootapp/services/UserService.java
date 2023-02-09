package com.bhati.demospringbootapp.services;

import java.util.List;
// import java.util.UUID;

import com.bhati.demospringbootapp.models.State;
import com.bhati.demospringbootapp.models.User;

public interface UserService {
    // User user = utils.authenticateUser(username, userId:null);

    User createUser(User user) throws Exception;

    List<User> findAllUsers();

    User getUserById(Integer uid) throws Exception;

    State updatedata(Integer id, User user) throws Exception;

    void deleteuser(Integer id, User user) throws Exception;

}
