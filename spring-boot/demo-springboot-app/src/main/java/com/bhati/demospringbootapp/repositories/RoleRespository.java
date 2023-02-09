package com.bhati.demospringbootapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bhati.demospringbootapp.models.Role;

public interface RoleRespository extends JpaRepository<Role, Integer> {

}
