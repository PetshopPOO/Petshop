package com.petshop.models.application;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Serviço")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Servico {
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;
    private String tipo;
    private double valor;
    @OneToOne
    private Pet pet;
    @ManyToOne
    @JoinColumn(name = "Responsável")
    private Funcionario funcionario;
    
}
