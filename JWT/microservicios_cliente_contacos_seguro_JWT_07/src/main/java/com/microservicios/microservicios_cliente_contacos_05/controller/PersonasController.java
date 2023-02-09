package com.microservicios.microservicios_cliente_contacos_05.controller;


import com.microservicios.microservicios_cliente_contacos_05.model.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class PersonasController {

    @Autowired
    RestTemplate template;



    String url = "http://localhost:8080";
    String user = "admin";
    String pwd = "admin";
    String token;

    HttpHeaders headers = new HttpHeaders();

    @PostConstruct()
    public void autenticar() {
        token = template.postForObject( url + "/loggin?user=" + user + "&pwd=" +pwd, null, String.class );
        headers.add("Authorization", "Bearer " + token);

    }


    @GetMapping(value = "/personas/{nombre}/{email}/{edad}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Persona> altaPersona(@PathVariable( "nombre" ) String nombre,
                                      @PathVariable( "email" ) String email,
                                      @PathVariable( "edad" ) int edad) {

        Persona persona = new Persona(nombre, email, edad);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Bearer " + token);



            template.exchange(url +"/contactos", HttpMethod.POST, new HttpEntity<Persona>( persona, headers), String.class);
            Persona[] personas = template.exchange(url + "/contactos", HttpMethod.GET, new HttpEntity<>(headers), Persona[].class).getBody();

            return Arrays.asList(personas);

    }


    @GetMapping(value = "personas/{edad1}/{edad2}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Persona> buscarEdades(@PathVariable( "edad1" ) int edad1, @PathVariable( "edad2" ) int edad2) {

        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Bearer " + token);
        Persona[] personas = template.exchange(url + "/contactos", HttpMethod.GET, new HttpEntity<>(headers), Persona[].class).getBody();

        return Arrays.stream(personas)
                .filter( p -> p.getEdad() >= edad1 && p.getEdad() <= edad2)
                .toList();
    }
}
