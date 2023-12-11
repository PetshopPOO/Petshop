package com.petshop.petshop.models;

import com.petshop.petshop.secondary.FormaPagamento;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VendaTotal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;
    @OneToMany(mappedBy = "codigoVenda", cascade = CascadeType.ALL)
    private List<Venda> itensVenda;
    @ManyToMany(mappedBy = "vendas", cascade = CascadeType.ALL)
    private List<FormaPagamento> formasPagamento;
    @ManyToOne
    private Cliente cliente;
    @ManyToOne
    private Funcionario funcionario;

    public VendaTotal(Long codigo) {
        this.codigo = codigo;
    }
}

