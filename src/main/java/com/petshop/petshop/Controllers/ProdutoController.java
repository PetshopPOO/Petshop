package com.petshop.petshop.Controllers;


import com.petshop.petshop.DTO.CompraProdutoDTO;
import com.petshop.petshop.DTO.ProdutoCodigoDTO;
import com.petshop.petshop.DTO.ProdutoRequestDTO;
import com.petshop.petshop.models.Fornecedor;
import com.petshop.petshop.models.Produto;
import com.petshop.petshop.repositories.FornecedorRp;
import com.petshop.petshop.repositories.ProdutoRp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("produto")
public class ProdutoController {
    @Autowired
    ProdutoRp produtoRp;

    @Autowired
    FornecedorRp fornecedorRp;

    @GetMapping
    public Iterable<Produto> getAll(){
        Iterable<Produto> produtos = produtoRp.findAll();
        System.out.println(produtos);
        return produtos;
    }

    @GetMapping("codigo")
    public Optional<Produto> getByCodigo(@RequestBody ProdutoCodigoDTO data){
        return produtoRp.findById(data.codigo());

    }
    @PostMapping
    public void addProduto(@RequestBody ProdutoRequestDTO data){
        Fornecedor fornecedor = fornecedorRp.findByCnpj(data.fornecedor());
        Produto produtoData = new Produto(data);
        produtoData.setFornecedor(fornecedor);
        produtoRp.save(produtoData);
    }

    @PostMapping("compra")
    public void compraProduto(@RequestBody CompraProdutoDTO data){
        Optional<Produto> produtoOp = produtoRp.findById(data.codigo());
        Produto produto = new Produto(produtoOp.get().getCodigo(), produtoOp.get().getNome(),produtoOp.get().getPreco(), produtoOp.get().getEstoque(),produtoOp.get().getFornecedor());
        produto.setEstoque(produto.getEstoque() + data.quantidade());
        produtoRp.save(produto);
    }
}
