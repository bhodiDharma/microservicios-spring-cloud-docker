package com._microservicios_reservas.dao;

import com._microservicios_reservas.model.Reserva;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ReservaDaoImpl implements ReservaDao {

    @Autowired
    ReservaRepository reservas;

    @Override
    public void generarReserva(Reserva reserva) {
        reservas.save( reserva );
    }

    @Override
    public List<Reserva> getReservas() {
        return reservas.findAll();
    }
}
