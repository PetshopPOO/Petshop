package com.petshop.petshop.Controllers;

import com.petshop.petshop.DTO.FuncionarioCpfDTO;
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
    public boolean addFuncionario(@RequestBody FuncionarioRequestDTO data) {
        if (!funcionarioRp.existsById(data.cpf())) {
            Funcionario funcionarioData = new Funcionario(data);
            funcionarioRp.save(funcionarioData);
            return true;
        }
        return false;
    }
    @GetMapping("cpf")
    public Funcionario getFuncionarioById(FuncionarioCpfDTO data){
        if(funcionarioRp.existsById(data.cpf())){
            return funcionarioRp.findById(data.cpf()).get();
        }
        return null;
    }
    @DeleteMapping("deletaFuncionario")
    public boolean deletaFuncionario(FuncionarioCpfDTO data){
        if(funcionarioRp.existsById(data.cpf())){
            Funcionario funcionario = funcionarioRp.findById(data.cpf()).get();
            funcionarioRp.delete(funcionario);
            return true;
        }
        return false;
    }
}
