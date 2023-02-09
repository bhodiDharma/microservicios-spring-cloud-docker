package com.example.microservicios_personalizar_respuesta;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class MicroserviciosPersonalizarRespuestaApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviciosPersonalizarRespuestaApplication.class, args);
	}

	@Bean
	public RestTemplate template() {
		return new RestTemplate();
	}

}
