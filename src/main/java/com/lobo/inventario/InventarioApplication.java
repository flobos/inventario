package com.lobo.inventario;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;



@SpringBootApplication
@EntityScan("com.lobo.inventario")
public class InventarioApplication {
	public static void main(String[] args) {
		SpringApplication.run(InventarioApplication.class, args);
	}
}
