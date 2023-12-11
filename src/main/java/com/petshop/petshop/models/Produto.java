package com.petshop.petshop.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.petshop.petshop.DTO.ProdutoRequestDTO;
import jakarta.persistence.*;

import lombok.*;

@Entity
@Table(name = "Produto")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Produto {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;
    private String nome;
    private double preco;
    private int estoque = 0;
    @ManyToOne
    @JsonBackReference
    private Fornecedor fornecedor;
    @OneToOne
    private Venda itemVenda;

    public Produto (ProdutoRequestDTO data){
        this.nome = data.nome();
        this.preco = data.preco();
    }

    public Produto(Long codigo, String nome, double preco, int estoque, Fornecedor fornecedor) {
        this.codigo = codigo;
        this.nome = nome;
        this.preco = preco;
        this.estoque = estoque;
        this.fornecedor = fornecedor;
    }
}


