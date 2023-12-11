package com.petshop.petshop.Controllers;

import com.petshop.petshop.DTO.FuncionarioRequestDTO;
import com.petshop.petshop.models.Funcionario;
import com.petshop.petshop.repositories.FuncionarioRp;
import com.petshop.petshop.secondary.Endereco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("funcionario")
public class FuncionarioController {
    @Autowired
    private FuncionarioRp funcionarioRp;

    @GetMapping
    public Iterable<Funcionario> getAll(){
        return funcionarioRp.findAll();
    }

    @PostMapping
    public void addFuncionario(@RequestBody FuncionarioRequestDTO data){
        Funcionario funcionarioData = new Funcionario(data);
        funcionarioRp.save(funcionarioData);
        System.out.println(data);
    }



}
