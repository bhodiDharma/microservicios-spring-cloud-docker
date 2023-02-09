package com.microservicios.microservicios_cliente_contacos_05.services;

import com.microservicios.microservicios_cliente_contacos_05.model.Persona;
import org.springframework.scheduling.annotation.Async;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface AccesoService {
    @Async
    CompletableFuture<List<Persona>> llamadaServicio(Persona persona);
}
