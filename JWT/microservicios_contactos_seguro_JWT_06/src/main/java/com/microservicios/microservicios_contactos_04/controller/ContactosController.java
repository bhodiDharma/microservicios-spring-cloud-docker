package com.microservicios.microservicios_contactos_04.controller;


import com.microservicios.microservicios_contactos_04.model.Contacto;
import com.microservicios.microservicios_contactos_04.service.AgendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ContactosController {

    @Autowired
    AgendaService service;

    @GetMapping(value = "contactos", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Contacto> recuperarContactos(){

        try {
            Thread.sleep(8000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return service.recuperarContactos();
    }

    @GetMapping(value = "contactos/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Contacto recuperarContacto(@PathVariable("id") int id){



        return service.buscarContacto(id);
    }

    @PostMapping(value = "contactos", consumes = MediaType.APPLICATION_JSON_VALUE,
                    produces = MediaType.TEXT_PLAIN_VALUE)
    public String guardarContacto(@RequestBody Contacto contacto){
        return String.valueOf(service.agregarContacto( contacto ));
    }


    @PutMapping(value = "contactos", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void actualizarContacto( @RequestBody Contacto contacto){
        service.actualizarContacto( contacto );
    }

    @DeleteMapping( value = "contactos/{id}")
    public void eliminarPorId(@PathVariable("id") int idContacto) {
        service.eliminarContacto(idContacto);
    }




}
