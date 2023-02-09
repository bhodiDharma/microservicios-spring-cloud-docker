package com.microservicios.microservicios_cliente_contacos_05.controller;


import com.microservicios.microservicios_cliente_contacos_05.model.Persona;
import com.microservicios.microservicios_cliente_contacos_05.services.AccesoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@RestController
public class PersonasController {

    @Autowired
    AccesoService accesoService;


    @GetMapping(value = "/personas/{nombre}/{email}/{edad}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Persona> altaPersona(@PathVariable( "nombre" ) String nombre,
                                     @PathVariable( "email" ) String email,
                                     @PathVariable( "edad" ) int edad) throws InterruptedException {

        Persona persona = new Persona(nombre, email, edad);

        CompletableFuture<List<Persona>> resultado = accesoService.llamadaServicio(persona);

        for(int i = 0; i < 50; i++){
            System.out.println("esperando ...");
            Thread.sleep(50);
        }

        try {
            return resultado.get();
        } catch (ExecutionException e) {
            return null;
        }

    }


    /*
    @GetMapping(value = "personas/{edad1}/{edad2}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Persona> buscarEdades(@PathVariable( "edad1" ) int edad1, @PathVariable( "edad2" ) int edad2) {
        Persona[] personas = template.getForObject( url +"/contactos", Persona[].class);

        return Arrays.stream(personas)
                .filter( p -> p.getEdad() >= edad1 && p.getEdad() <= edad2)
                .toList();
    }

     */
}
