package com.petshop.interfaces.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.petshop.models.application.Produto;

@Repository
public interface ProdutoRp extends CrudRepository<Produto, Long>{
    
}
