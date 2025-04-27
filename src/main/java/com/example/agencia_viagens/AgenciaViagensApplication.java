package com.example.agencia_viagens;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.example.agencia_viagens")
public class AgenciaViagensApplication {

	public static void main(String[] args) {
		SpringApplication.run(AgenciaViagensApplication.class, args);
	}

}
