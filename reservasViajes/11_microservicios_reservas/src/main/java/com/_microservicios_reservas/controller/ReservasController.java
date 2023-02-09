package com._microservicios_reservas.controller;


import com._microservicios_reservas.model.Reserva;
import com._microservicios_reservas.service.ReservasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class ReservasController {

    @Autowired
    ReservasService service;

    @PostMapping(value = "reserva/{personas}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void generarReserva(@RequestBody Reserva reserva, @PathVariable("personas") int personas ) {
        this.service.realizarReserva(reserva, personas);
    }

    @GetMapping(value = "reservas", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Reserva> getReservas() {
        return this.service.getReservas();
    }

}
