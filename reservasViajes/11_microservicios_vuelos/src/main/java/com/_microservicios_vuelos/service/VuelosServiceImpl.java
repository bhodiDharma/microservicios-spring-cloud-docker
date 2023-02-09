package com._microservicios_vuelos.service;

import com._microservicios_vuelos.dao.VueloDao;
import com._microservicios_vuelos.model.Vuelo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VuelosServiceImpl implements VuelosService {

    @Autowired
    VueloDao dao;

    @Override
    public List<Vuelo> recuperarVuelosDisponibles(int plazas) {
        return dao.devolverVuelos().stream()
                .filter( v -> v.getPlazas() >= plazas)
                .toList();
    }

    @Override
    public void actualizarPlazas(int idvuelo, int plazas) {
        Vuelo vuelo = dao.devolverVuelo(idvuelo);
        if( vuelo !=  null) {
            vuelo.setPlazas(vuelo.getPlazas() - plazas);
            dao.actualizarVuelo(vuelo);
        }
    }
}
