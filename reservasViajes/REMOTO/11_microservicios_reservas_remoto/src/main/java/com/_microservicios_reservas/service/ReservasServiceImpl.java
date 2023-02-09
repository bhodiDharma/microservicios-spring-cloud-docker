package com._microservicios_reservas.service;

import com._microservicios_reservas.dao.ReservaDao;
import com._microservicios_reservas.model.Reserva;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@Service
public class ReservasServiceImpl implements ReservasService {

    @Autowired
    ReservaDao reservas;

    @Autowired
    RestTemplate template;

    String url = "http://servicio-vuelos";

    @Override
    public void realizarReserva(Reserva reserva, int totalPersonas) {

        reservas.generarReserva( reserva );

        template.put(url + "/vuelos/{p1}/{p2}", null, reserva.getVuelo(), totalPersonas);

    }

    @Override
    public List<Reserva> getReservas() {

        return reservas.getReservas();
    }
}
