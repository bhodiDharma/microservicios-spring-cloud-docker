package com._microservicios_vuelos.dao;

import com._microservicios_vuelos.model.Vuelo;

import java.util.List;

public interface VueloDao {

    public List<Vuelo> devolverVuelos();

    public Vuelo devolverVuelo( int idvuelo);

    public void actualizarVuelo( Vuelo vuelo );
}
