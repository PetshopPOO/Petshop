package com.petshop.models.secondary;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.petshop.interfaces.FormaPagamento;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Cartao de Crédito")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CartaoCredito implements FormaPagamento{
    private String nomeTitular;
    @Id
    private int numero;
    private String codigoSeguranca;
    private String bandeira;
    private LocalDate dtVencimento;

    
}
