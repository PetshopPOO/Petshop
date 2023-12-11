package com.petshop.petshop.models;

import java.util.ArrayList;
import java.util.List;

import com.petshop.petshop.DTO.FuncionarioRequestDTO;
import com.petshop.petshop.secondary.Endereco;
import com.petshop.petshop.secondary.Pessoa;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Funcionario extends Pessoa{
    private Long matricula;
    private String rg;
    private double salario;
    @ManyToOne
    private Funcionario supervisor;
    @OneToMany(mappedBy = "funcionario")
    private List<Servico> servicos;
    @OneToMany(mappedBy = "funcionario")
    private List<VendaTotal> vendas;

    public Funcionario(String cpf, String nome, String[] telefones, Endereco endereco, Long matricula, String rg,
            double salario) {
        super(cpf, nome, telefones, endereco);
        this.matricula = matricula;
        this.rg = rg;
        this.salario = salario;
        servicos = new ArrayList<Servico>();
        vendas = new ArrayList<VendaTotal>();
    }

    public Funcionario (FuncionarioRequestDTO data){
        super(data.cpf(), data.nome(), data.telefones(), new Endereco(data.rua(), data.bairro(), data.cidade()));
        this.matricula = data.matricula();
        this.rg = data.rg();
        this.salario = data.salario();

    }
}
