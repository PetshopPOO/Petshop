package com.petshop.models.secondary;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name ="Pessoa")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Inheritance
public abstract class Pessoa{
    @Id
    private String cpf;
    private String nome;
    private String[] telefones;
    private Endereco endereco;
}