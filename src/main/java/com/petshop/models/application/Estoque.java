package com.petshop.models.application;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Estoque")  
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Estoque {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigoLote;
    private List<Produto> produtos;
    private LocalDate dtValidade;
    private int quantidade;
    @OneToMany(mappedBy = "estoque")
    private List<Fornecedor> fornecedores;
}
