package com.mevy.diopattern.services.impl;

import java.util.Optional;
import org.springframework.stereotype.Service;

import com.mevy.diopattern.models.Address;
import com.mevy.diopattern.models.Client;
import com.mevy.diopattern.repositories.AddressRepository;
import com.mevy.diopattern.repositories.ClientRepository;
import com.mevy.diopattern.services.CepService;
import com.mevy.diopattern.services.ClientService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ClientServiceimpl implements ClientService {

    private ClientRepository repository;
    private AddressRepository addressRepository;
    private CepService cepService;

    @Override
    public Iterable<Client> findAll() {
        return repository.findAll();
    }

    @Override
    public Client findById(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public void create(Client client) {
        saveClientWithCep(client);
    }

    @Override
    public void update(Long id, Client client) {
        Optional<Client> clientBd = repository.findById(id);
        if (clientBd.isPresent()) {
            saveClientWithCep(client);
        }
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
    
    private void saveClientWithCep(Client client) {
        String cep = client.getEndereco().getCep();
        Address address = addressRepository.findById(cep).orElseGet(() -> {
            Address newAddress = cepService.consultCep(cep);
            addressRepository.save(newAddress);
            return newAddress;
        });
        client.setEndereco(address);
        repository.save(client);
    }

}
