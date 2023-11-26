package com.petshop.petshop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.petshop.petshop.models.Cliente;
import com.petshop.petshop.repositories.ClienteRp;
import com.petshop.petshop.secondary.Endereco;

@SpringBootApplication
public class PetshopApplication implements CommandLineRunner{
	@Autowired
	ClienteRp clienteRp;

	public static void main(String[] args) {
		SpringApplication.run(PetshopApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Endereco endereco = new Endereco("Rua dos Jacarés", "Trevo V", "Metrópolis");
		Cliente cliente = new Cliente("1112", "João", new String[2], endereco, "joao@gmail.com");
		System.out.println(cliente);
		clienteRp.save(cliente);


	}

}
