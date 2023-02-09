package com._microservicio_hoteles.service;

import com._microservicio_hoteles.dao.HotelDao;
import com._microservicio_hoteles.model.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceHotelesImpl implements ServiceHoteles {


    @Autowired
    HotelDao hotelDao;

    @Override
    public List<Hotel> devolverHotelesDisponibles() {
        List<Hotel> hoteles = hotelDao.devolverHoteles();

        return hoteles.stream()
                .filter( p -> p.getDisponible() == 1)
                .toList();
    }
}
