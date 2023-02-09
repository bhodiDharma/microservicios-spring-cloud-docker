package com.microservicios.microservicios_cliente_contacos_05;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class MicroserviciosClienteContacos05Application {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviciosClienteContacos05Application.class, args);
	}


	@Bean
	public RestTemplate template() {
		return new RestTemplate();
	}


}
