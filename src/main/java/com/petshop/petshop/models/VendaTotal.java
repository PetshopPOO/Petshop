package com.petshop.petshop.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.petshop.petshop.secondary.FormaPagamento;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class VendaTotal implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;
    @OneToMany(mappedBy = "codigoVenda", cascade = CascadeType.ALL)
    private List<Venda> itensVenda;
    @ManyToMany(mappedBy = "vendas", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<FormaPagamento> formasPagamento;
    @ManyToOne
    @JsonManagedReference
    private Cliente cliente;
    @ManyToOne
    @JsonManagedReference
    private Funcionario funcionario;

    public VendaTotal(Long codigo) {
        this.codigo = codigo;
    }
}

