package com.petshop.interfaces.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.petshop.models.application.Servico;

@Repository
public interface ServicoRp extends CrudRepository<Servico, Long>{
    
}
