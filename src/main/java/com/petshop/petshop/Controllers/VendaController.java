package com.petshop.petshop.Controllers;

import com.petshop.petshop.DTO.VendaRequestDTO;
import com.petshop.petshop.DTO.VendaTotalRequestDTO;
import com.petshop.petshop.models.*;
import com.petshop.petshop.repositories.*;
import com.petshop.petshop.secondary.FormaPagamento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("venda")


public class VendaController {
    @Autowired
    private ProdutoRp produtoRp;
    @Autowired
    FuncionarioRp funcionarioRp;
    @Autowired
    ClienteRp clienteRp;
    @Autowired
    VendaRp vendaRp;
    @Autowired
    VendaTotalRp vendaTotalRp;
    @PostMapping("itemVenda")
    public void itemVenda(@RequestBody VendaRequestDTO data){
        if(!vendaTotalRp.existsById(data.codigoVenda().getCodigo())) {
            vendaTotalRp.save(new VendaTotal(data.codigoVenda().getCodigo()));
        }
        Optional<VendaTotal> vendaTotalOp = vendaTotalRp.findById(data.codigoVenda().getCodigo());
        VendaTotal vendaTotal = new VendaTotal(vendaTotalOp.get().getCodigo());
        Optional<Produto> produtoOp = produtoRp.findById(data.codigo());
        Produto produto = new Produto(produtoOp.get().getCodigo(), produtoOp.get().getNome(), produtoOp.get().getPreco(), produtoOp.get().getEstoque(), produtoOp.get().getFornecedor());
        Venda itemVenda = new Venda(data.valor(), produto, data.quantidade(), vendaTotal);
        vendaRp.save(itemVenda);
        }

        @PostMapping("finalizaVenda")
    public void finalizaVenda(@RequestBody VendaTotalRequestDTO data){
            System.out.println(data.codigoVenda());
        if(!vendaTotalRp.existsById(data.codigoVenda())) {
            vendaTotalRp.save(new VendaTotal(data.codigoVenda()));
        }
        vendaTotalRp.existsById(1L);
            System.out.println("Aqui");
        Optional<VendaTotal> vendaTotalOp = vendaTotalRp.findById(1L);
        System.out.println("vendaTotalOp");
        VendaTotal vendaTotal = new VendaTotal(vendaTotalOp.get().getCodigo());
        System.out.println("Aqui");
        Iterable<Venda> totalVendas = vendaRp.findAll();
        ArrayList<Venda> itensVenda = new ArrayList<>();
        System.out.println("Entrou no if");
        for (Venda venda:totalVendas) {
            if(venda.getCodigoVenda().getCodigo() == vendaTotal.getCodigo()){
                itensVenda.add(venda);
            }
        }
        List<FormaPagamento> formasPagamento = data.formasPagamento();
        Optional<Funcionario> funcionarioOp = funcionarioRp.findById(data.funcionario());
        Funcionario funcionario = new Funcionario(funcionarioOp.get().getCpf(),funcionarioOp.get().getNome(),funcionarioOp.get().getTelefones(), funcionarioOp.get().getEndereco(), funcionarioOp.get().getMatricula(), funcionarioOp.get().getRg(), funcionarioOp.get().getSalario());
        Optional<Cliente> clienteOp = clienteRp.findById(data.cliente());
        Cliente cliente = new Cliente(clienteOp.get().getCpf(), clienteOp.get().getNome(),clienteOp.get().getTelefones(), clienteOp.get().getEndereco(), clienteOp.get().getEmail());
        vendaTotal.setItensVenda(itensVenda);
        vendaTotal.setFormasPagamento(formasPagamento);
        vendaTotal.setCliente(cliente);
        vendaTotal.setFuncionario(funcionario);
        vendaTotalRp.save(vendaTotal);
    }


}
