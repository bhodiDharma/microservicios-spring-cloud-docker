package com._microservicios_vuelos.service;

import com._microservicios_vuelos.model.Vuelo;

import java.util.List;

public interface VuelosService {

    List<Vuelo> recuperarVuelosDisponibles(int plazas );
    void actualizarPlazas( int idvuelo, int plazas );

}
