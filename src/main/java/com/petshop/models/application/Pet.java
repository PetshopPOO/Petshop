package com.petshop.models.application;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Pet")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Pet {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo; 
    private String nome;
    private String especie;
    private char sexo;
    private Cliente tutor;
    
}
