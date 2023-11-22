package com.petshop.models.secondary;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Endereco {
    private String rua;
    private String bairro;
    private String cidade;  
}
