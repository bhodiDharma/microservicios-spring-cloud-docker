package com._microservicio_hoteles.dao;

import com._microservicio_hoteles.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface HotelRepository extends JpaRepository<Hotel, Integer> {
}