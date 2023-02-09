package com._microservicios_vuelos.dao;

import com._microservicios_vuelos.model.Vuelo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VueloRepository extends JpaRepository<Vuelo, Integer> {
}