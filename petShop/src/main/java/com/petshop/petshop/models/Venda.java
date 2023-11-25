package com.petshop.petshop.models;

import java.util.ArrayList;
import java.util.List;

import com.petshop.petshop.secondary.FormaPagamento;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Venda {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;
    private double valor;
    @OneToMany
    private List<FormaPagamento> formasPagamentos;
    @OneToMany(mappedBy = "venda")
    private List<Produto> produtos;
    @ManyToOne
    @JoinColumn(name = "Vendedor")
    private Funcionario funcionario;
    @OneToOne
    private Cliente cliente;

    
    public Venda(double valor, List<FormaPagamento> formasPagamentos, Cliente cliente) {
        this.valor = valor;
        this.formasPagamentos = formasPagamentos;
        this.cliente = cliente;
        produtos = new ArrayList<Produto>();
    }
    
    public Venda(double valor) {
        this.valor = valor;
        produtos = new ArrayList<Produto>();
    }  
}
