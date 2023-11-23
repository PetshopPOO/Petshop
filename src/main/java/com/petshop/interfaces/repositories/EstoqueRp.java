package com.petshop.interfaces.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.petshop.models.application.Estoque;

@Repository
public interface EstoqueRp extends CrudRepository<Estoque, Long>{
    
}
