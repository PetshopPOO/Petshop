package com.petshop.petshop.models;

import java.util.ArrayList;
import java.util.List;

import com.petshop.petshop.secondary.Endereco;
import com.petshop.petshop.secondary.Pessoa;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Cliente extends Pessoa{
    private String email;
    @OneToMany(mappedBy = "tutor")
    private List<Pet> pets;

    
    public Cliente(String cpf, String nome, String[] telefones, Endereco endereco,String email) {
        super(cpf, nome, telefones, endereco);
        this.email = email;
        pets = new ArrayList<Pet>();
    }


    @Override
    public String toString() {
        return super.toString() + "Cliente [email=" + email + ", pets=" + pets + "]";
    }
    
}
