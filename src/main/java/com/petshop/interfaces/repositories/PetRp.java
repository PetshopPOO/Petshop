package com.petshop.interfaces.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.petshop.models.application.Pet;

@Repository
public interface PetRp extends CrudRepository<Pet, Long>{
    
}
