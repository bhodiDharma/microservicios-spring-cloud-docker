package com.microservicios.microservicios_cliente_contacos_05;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

@SpringBootApplication
@EnableAsync
public class MicroserviciosClienteContacos05Application {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviciosClienteContacos05Application.class, args);
	}

	@Bean
	public RestTemplate template() {

		return new RestTemplate();
	}


	@Bean
	public Executor executor() {
		return new ThreadPoolTaskExecutor();
	}


}
