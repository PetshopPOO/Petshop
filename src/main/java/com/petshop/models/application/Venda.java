package com.petshop.models.application;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.petshop.interfaces.FormaPagamento;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Venda")
@Getter
@Setter
@NoArgsConstructor
public class Venda {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;
    private double valor;
    private FormaPagamento formaPagamento;
    private List<Produto> produtos;
    private Funcionario funcionario;
    private Cliente cliente;

    
    public Venda(double valor, FormaPagamento formaPagamento, Cliente cliente) {
        this.valor = valor;
        this.formaPagamento = formaPagamento;
        this.cliente = cliente;
        produtos = new ArrayList<Produto>();
    }
    
    public Venda(double valor) {
        this.valor = valor;
        produtos = new ArrayList<Produto>();
    }  
}
