package com._microservicios_reservas.dao;

import com._microservicios_reservas.model.Reserva;

import java.util.List;

public interface ReservaDao {

    public void generarReserva( Reserva reserva);

    List<Reserva> getReservas();
}
