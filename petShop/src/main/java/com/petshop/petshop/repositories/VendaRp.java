package com.petshop.petshop.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.petshop.petshop.models.Venda;

@Repository
public interface VendaRp extends CrudRepository<Venda, Long>{
    
}
