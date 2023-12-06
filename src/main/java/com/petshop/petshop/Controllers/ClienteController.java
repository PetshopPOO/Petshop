package com.petshop.petshop.Controllers;


import com.petshop.petshop.DTO.ClienteCpfDTO;
import com.petshop.petshop.DTO.ClienteRequestDTO;
import com.petshop.petshop.models.Cliente;
import com.petshop.petshop.repositories.ClienteRp;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.annotation.Target;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("cliente")
@NoArgsConstructor
public class ClienteController {
    @Autowired
    private ClienteRp clienteRp;

    @GetMapping
    public Iterable<Cliente> getAll(){

        try
        {
            System.out.println(clienteRp.findAll());
        return clienteRp.findAll();}
        catch(Exception e){
            System.out.println("Fodeu");
            return null;
        }

    }

    @PostMapping
    public void addCliente(@RequestBody ClienteRequestDTO data){
        Cliente clienteData = new Cliente(data);
        clienteRp.save(clienteData);
        return;
    }

    @GetMapping("cpf")
    public Cliente getClienteByCpf(@RequestBody ClienteCpfDTO data){
        Cliente cliente = clienteRp.findByCpf(data.cpf());
        System.out.println(cliente.getPets());
        return cliente;
    }


}
