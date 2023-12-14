package com.petshop.petshop.Controllers;

import com.petshop.petshop.DTO.FornecedorCnpjDTO;
import com.petshop.petshop.DTO.FornecedorRequestDTO;
import com.petshop.petshop.models.Cliente;
import com.petshop.petshop.models.Fornecedor;
import com.petshop.petshop.repositories.FornecedorRp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("fornecedor")

public class FornecedorController {
    @Autowired
    private FornecedorRp fornecedorRp;

    @GetMapping
    public Iterable<Fornecedor> getAll() {
        return fornecedorRp.findAll();
    }

    @GetMapping("cnpj")
    public Fornecedor getFornecedorByCnpj(@RequestBody FornecedorCnpjDTO data){
        if(fornecedorRp.existsById(data.cnpj())){
            Fornecedor fornecedor = fornecedorRp.findById(data.cnpj()).get();
            return fornecedor;
        }
        return null;

    }

    @PostMapping
    public boolean addFornecedor(@RequestBody FornecedorRequestDTO data) {
        if(!fornecedorRp.existsById(data.cnpj())){
            Fornecedor fornecedorData = new Fornecedor(data);
            fornecedorRp.save(fornecedorData);
            return true;
        }
        return false;

    }
}
