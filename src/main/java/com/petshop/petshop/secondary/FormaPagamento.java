package com.petshop.petshop.secondary;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.petshop.petshop.models.VendaTotal;
import jakarta.persistence.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class FormaPagamento {
    @Id
    private String tipo;
    @ManyToMany
    @JsonBackReference(value="pagamento-venda")
    private List<VendaTotal> vendas;
}