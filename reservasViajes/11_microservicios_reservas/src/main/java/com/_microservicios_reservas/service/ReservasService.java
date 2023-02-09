package com._microservicios_reservas.service;

import com._microservicios_reservas.model.Reserva;

import java.util.List;

public interface ReservasService {

    void realizarReserva( Reserva reserva, int totalPersonas);
    List<Reserva> getReservas();

}
