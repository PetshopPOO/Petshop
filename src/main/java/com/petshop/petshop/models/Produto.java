package com.petshop.petshop.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.petshop.petshop.DTO.ProdutoRequestDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

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
    private Venda venda;
    @ManyToOne
    @JsonBackReference
    private Fornecedor fornecedor;

    public Produto (ProdutoRequestDTO data){
        this.nome = data.nome();
        this.preco = data.preco();
    }
}


