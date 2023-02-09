package com.bhati.demospringbootapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bhati.demospringbootapp.models.Project;

public interface ProjectRespository extends JpaRepository<Project, Integer> {
    Project findByName(String name);
}
