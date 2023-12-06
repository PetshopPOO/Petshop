package com.petshop.petshop.Controllers;

import com.petshop.petshop.DTO.FuncionarioRequestDTO;
import com.petshop.petshop.models.Funcionario;
import com.petshop.petshop.repositories.FuncionarioRp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public void addFuncionario(FuncionarioRequestDTO data){
        Funcionario funcionarioData = new Funcionario(data);
        funcionarioRp.save(funcionarioData);
    }



}
