package com._microservicio_hoteles.controller;


import com._microservicio_hoteles.model.Hotel;
import com._microservicio_hoteles.service.ServiceHoteles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class HotelesController {

    @Autowired
    ServiceHoteles service;

    @GetMapping(value = "hoteles", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Hotel> devolverHoteles() {
        return service.devolverHotelesDisponibles();
    }

}
