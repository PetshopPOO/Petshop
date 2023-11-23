package com.petshop.models.application;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.petshop.models.secondary.Endereco;
import com.petshop.models.secondary.Pessoa;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Funcionário")
@Getter
@Setter
@NoArgsConstructor
public class Funcionario extends Pessoa{

    @Id
    private Long matricula;
    private String rg;
    private double salario;
    @ManyToOne
    private Funcionario supervisor;
    @OneToMany(mappedBy = "funcionario")
    private List<Servico> servicos;
    @OneToMany(mappedBy = "funcionario")
    private List<Venda> vendas;

    public Funcionario(String cpf, String nome, String[] telefones, Endereco endereco, Long matricula, String rg,
            double salario) {
        super(cpf, nome, telefones, endereco);
        this.matricula = matricula;
        this.rg = rg;
        this.salario = salario;
        servicos = new ArrayList<Servico>();
        vendas = new ArrayList<Venda>();
    }    
}
