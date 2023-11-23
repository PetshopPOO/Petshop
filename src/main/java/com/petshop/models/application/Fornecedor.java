package com.petshop.models.application;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.petshop.models.secondary.Endereco;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Fornecedor")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Fornecedor {
    private String cnpj;
    private String nome;
    private String[] telefones;
    private Endereco endereco;
    @ManyToOne
    @JoinColumn(name = "estoque")
    private Estoque estoque;

}
