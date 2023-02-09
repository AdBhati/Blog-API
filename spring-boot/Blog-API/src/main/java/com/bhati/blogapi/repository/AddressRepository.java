package com.bhati.blogapi.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bhati.blogapi.model.Address;

public interface AddressRepository extends JpaRepository<Address, UUID> {

}
