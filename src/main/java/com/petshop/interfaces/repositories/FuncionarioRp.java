package com.petshop.interfaces.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.petshop.models.application.Funcionario;

@Repository
public interface FuncionarioRp extends CrudRepository<Funcionario, Long> {
    
}
