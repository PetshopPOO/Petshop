package com.petshop.interfaces.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.petshop.models.application.Cliente;

@Repository
public interface ClienteRp extends CrudRepository<Cliente, String> {
    
}
