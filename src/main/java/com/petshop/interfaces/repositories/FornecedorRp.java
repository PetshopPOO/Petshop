package com.petshop.interfaces.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.petshop.models.application.Fornecedor;

@Repository
public interface FornecedorRp extends CrudRepository<Fornecedor, String>{
    
}
