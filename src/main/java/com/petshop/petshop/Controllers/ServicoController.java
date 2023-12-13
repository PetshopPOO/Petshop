package com.petshop.petshop.Controllers;

import com.petshop.petshop.DTO.ServicoRealizaDTO;
import com.petshop.petshop.DTO.ServicoRealizadoIdDTO;
import com.petshop.petshop.DTO.ServicoRequestDTO;
import com.petshop.petshop.models.Funcionario;
import com.petshop.petshop.models.Pet;
import com.petshop.petshop.models.Servico;
import com.petshop.petshop.models.ServicoRealizado;
import com.petshop.petshop.repositories.FuncionarioRp;
import com.petshop.petshop.repositories.PetRp;
import com.petshop.petshop.repositories.ServicoRealizadoRp;
import com.petshop.petshop.repositories.ServicoRp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("servico")



public class ServicoController {
    @Autowired
    ServicoRp servicoRp;
    @Autowired
    PetRp petRp;
    @Autowired
    FuncionarioRp funcionarioRp;
    @Autowired
    ServicoRealizadoRp servicoRealizadoRp;
    @PostMapping("cadastraServico")
    public void cadastraServico (@RequestBody ServicoRequestDTO data) {
        Servico servico = new Servico();
        servico.setTipo(data.tipo());
        servico.setValor(data.valor());
        servicoRp.save(servico);
    }
    @PostMapping("realizaServico")
    public void realizaServico(@RequestBody ServicoRealizaDTO data){
        Optional<Servico> servicoOp = servicoRp.findById(data.servico());
        Servico servico = servicoOp.get();
        Pet pet = petRp.findById(data.pet()).get();
        Funcionario funcionario = funcionarioRp.findById(data.funcionario()).get();
        ServicoRealizado servicoRealizado = new ServicoRealizado(servico, pet, funcionario);
        servicoRealizadoRp.save(servicoRealizado);
    }

    @GetMapping("servicos")
    public Iterable<Servico> getAllServicos (){
        return servicoRp.findAll();
    }

    @GetMapping("servicosRealizados")
    public Iterable<ServicoRealizado> getAllServicosRealizados(){
        return servicoRealizadoRp.findAll();
    }

    @GetMapping("servicobyid")
    public Servico getServicoById(@RequestBody Long id){
        return servicoRp.findById(id).get();
    }
    @GetMapping("servicoRealizadoById")
    public Optional<ServicoRealizado> getServicoRealizadoById(@RequestBody ServicoRealizadoIdDTO data){
        System.out.println(data.id());
        return servicoRealizadoRp.findById(data.id());
    }
}
