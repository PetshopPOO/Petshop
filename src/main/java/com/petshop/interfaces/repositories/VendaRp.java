package com.petshop.interfaces.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.petshop.models.application.Venda;

@Repository
public interface VendaRp extends CrudRepository<Venda, Long>{
    
}
