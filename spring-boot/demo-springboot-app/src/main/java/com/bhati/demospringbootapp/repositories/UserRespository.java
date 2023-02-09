package com.bhati.demospringbootapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bhati.demospringbootapp.models.User;

public interface UserRespository extends JpaRepository<User, Integer> {
    User findByEmail(String email);

    // @Query(value = "SELECT * from Users WHERE username =: username", nativeQuery
    // = true)
    // Optional<User> findUserName(String username);
}
