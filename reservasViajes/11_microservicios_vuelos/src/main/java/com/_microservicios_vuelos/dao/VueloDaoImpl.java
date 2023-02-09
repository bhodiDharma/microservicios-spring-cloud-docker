package com._microservicios_vuelos.dao;

import com._microservicios_vuelos.model.Vuelo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class VueloDaoImpl implements VueloDao  {

    @Autowired
    VueloRepository vuelos;

    @Override
    public List<Vuelo> devolverVuelos() {
        return vuelos.findAll();
    }

    @Override
    public Vuelo devolverVuelo(int idvuelo) {
        return vuelos.findById( idvuelo ).orElse(null );
    }

    @Override
    public void actualizarVuelo(Vuelo vuelo) {
        vuelos.save( vuelo );
    }
}
