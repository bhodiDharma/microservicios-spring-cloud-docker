package com.microservicios.microservicios.controller;


import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SaludoController {

    @GetMapping(value = "saludo", produces = MediaType.TEXT_PLAIN_VALUE)
    public String saludo() {
        return "MicroServicio Spring Boot";
    }
    @GetMapping(value = "saludo/{name}", produces = MediaType.TEXT_PLAIN_VALUE)
    public String saludo(@PathVariable("name")  String n) {
        return "Bienvenido " + n;
    }


}
