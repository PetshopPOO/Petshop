package com.petshop.petshop.Controllers;

import com.petshop.petshop.DTO.ClienteCpfDTO;
import com.petshop.petshop.DTO.PetRequestDTO;
import com.petshop.petshop.models.Cliente;
import com.petshop.petshop.models.Pet;
import com.petshop.petshop.repositories.ClienteRp;
import com.petshop.petshop.repositories.PetRp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("pet")

public class PetController {
    @Autowired
    private PetRp petRp;
    @Autowired
    private ClienteRp clienteRp;

    @GetMapping
    public List<Pet> getAll(){
        List<Pet> pets = petRp.findAll();
        return pets;
    }

    @GetMapping("tutor")
    public Iterable<Pet> getAllByTutor(@RequestBody ClienteCpfDTO data){
        ClienteController cc = new ClienteController();
        Cliente cliente = cc.getClienteByCpf(data);
        return cliente.getPets();
    }
    @PostMapping
    public void addPet(@RequestBody PetRequestDTO data){
        Pet pet = new Pet(data);
        pet.setTutor(clienteRp.findByCpf(data.tutor()));
        petRp.save(pet);
    }
}
