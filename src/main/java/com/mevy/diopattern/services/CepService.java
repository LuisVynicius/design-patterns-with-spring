package com.mevy.diopattern.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.mevy.diopattern.models.Address;

@FeignClient(name = "cepService", url = "https://viacep.com.br/ws")
public interface CepService {
    
    @GetMapping(value = "/{cep}/json/")
    Address consultCep(@PathVariable("cep") String cep);

}
