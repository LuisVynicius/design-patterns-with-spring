package com.mevy.diopattern.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mevy.diopattern.models.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {
    
}
