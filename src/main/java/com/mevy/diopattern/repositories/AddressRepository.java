package com.mevy.diopattern.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mevy.diopattern.models.Address;

public interface AddressRepository extends JpaRepository<Address, String> {

}