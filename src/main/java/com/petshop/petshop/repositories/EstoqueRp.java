package com.petshop.petshop.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.petshop.petshop.models.Estoque;

@Repository
public interface EstoqueRp extends CrudRepository<Estoque, Long>{
    
}
