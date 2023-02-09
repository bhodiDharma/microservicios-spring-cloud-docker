package com.microservicios.microservicios_cliente_contacos_05.services;

import com.microservicios.microservicios_cliente_contacos_05.model.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class AccesoServiceImpl implements AccesoService {

    @Autowired
    RestTemplate template;

    String url = "http://localhost:8080";

    @Override
    @Async
    public CompletableFuture<List<Persona>> llamadaServicio(Persona persona) {

        template.postForLocation(url +"/contactos", persona);
        Persona[] personas = template.getForObject(url + "/contactos", Persona[].class);
        return CompletableFuture.completedFuture( Arrays.stream(personas).toList() );


    }
}
