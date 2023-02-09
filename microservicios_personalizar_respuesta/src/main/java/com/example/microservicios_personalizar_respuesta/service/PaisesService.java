package com.example.microservicios_personalizar_respuesta.service;

import com.example.microservicios_personalizar_respuesta.model.Pais;

import java.util.List;

public interface PaisesService {

    List<Pais> obtenerPaises();
    List<Pais> buscarPaises(String name);
}
