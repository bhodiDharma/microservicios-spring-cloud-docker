package com._microservicios_vuelos.controller;


import com._microservicios_vuelos.model.Vuelo;
import com._microservicios_vuelos.service.VuelosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class VuelosController {

    @Autowired
    VuelosService service;

    @GetMapping(value = "vuelos/{plazas}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Vuelo> devolverVuelos(@PathVariable( "plazas" ) int plazas) {
        List<Vuelo> vuelos = service.recuperarVuelosDisponibles( plazas );
        return vuelos;
    }

    @PutMapping(value = "vuelos/{idvuelo}/{plazas}")
    public void modificarVuelo(@PathVariable("idvuelo") int id, @PathVariable("plazas") int plazas) {
        service.actualizarPlazas(id, plazas);
    }


}
