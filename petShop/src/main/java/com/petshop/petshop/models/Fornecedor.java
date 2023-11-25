package com.petshop.petshop.models;

import com.petshop.petshop.secondary.Endereco;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Fornecedor {
    @Id
    private String cnpj;
    private String nome;
    private String[] telefones;
    private Endereco endereco;
    @ManyToOne
    private Estoque estoque;

}
