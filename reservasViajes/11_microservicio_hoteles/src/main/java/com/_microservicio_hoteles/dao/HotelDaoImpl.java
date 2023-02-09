package com._microservicio_hoteles.dao;

import com._microservicio_hoteles.model.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class HotelDaoImpl implements HotelDao {

    @Autowired
    HotelRepository hotelRepository;

    @Override
    public List<Hotel> devolverHoteles() {
        return hotelRepository.findAll();
    }
}
