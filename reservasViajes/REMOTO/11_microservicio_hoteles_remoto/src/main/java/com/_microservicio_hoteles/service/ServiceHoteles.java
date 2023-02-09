package com._microservicio_hoteles.service;

import com._microservicio_hoteles.model.Hotel;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ServiceHoteles {

    public List<Hotel> devolverHotelesDisponibles();
}
