package com.bhati.demospringbootapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bhati.demospringbootapp.models.State;

public interface StateRespository extends JpaRepository<State, Integer> {
    State findByName(String name);

}
