package com.petshop.petshop.models;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Estoque {

    @Id
    private Long codigoLote;
    @OneToMany
    private List<Produto> produtos;
    private LocalDate dtValidade;
    private int quantidade;
    @OneToMany(mappedBy = "estoque")
    private List<Fornecedor> fornecedores;
}

