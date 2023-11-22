package com.petshop.models.application;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.petshop.models.secondary.Endereco;
import com.petshop.models.secondary.Pessoa;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Cliente")
@Getter
@Setter
@NoArgsConstructor
public class Cliente extends Pessoa{
    private String email;
    private List<Pet> pets;

    
    public Cliente(String cpf, String nome, String[] telefones, Endereco endereco, String email) {
        super(cpf, nome, telefones, endereco);
        this.email = email;
        pets = new ArrayList<Pet>();
    }
}
