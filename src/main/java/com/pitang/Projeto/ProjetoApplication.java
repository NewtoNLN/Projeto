package com.pitang.Projeto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackageClasses = {
		ProjetoApplication.class
})
public class ProjetoApplication {
	
	

	public static void main(String[] args) {
		SpringApplication.run(ProjetoApplication.class, args);
	}

}
