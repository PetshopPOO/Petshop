package com.petshop.models.secondary;

import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "Endereço")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Endereco {
    @Id
    private String referencia;  //cpf ou cnpj dependendo do caso  
    private String rua;
    private String bairro;
    private String cidade;
}
