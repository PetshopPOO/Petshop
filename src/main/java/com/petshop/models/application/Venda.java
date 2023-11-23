package com.petshop.models.application;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.petshop.models.secondary.FormaPagamento;

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
    @OneToMany(mappedBy = "venda")
    private List<FormaPagamento> formasPagamentos;
    @OneToMany
    private List<Produto> produtos;
    @ManyToOne
    @JoinColumn(name = "Vendedor")
    private Funcionario funcionario;
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
