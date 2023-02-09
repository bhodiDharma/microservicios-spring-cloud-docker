package com._microservicios_reservas.model;

import javax.persistence.*;

@Entity
@Table(name = "reservas")
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idreserva", nullable = false)
    private Integer id;

    @Column(name = "nombre", nullable = false, length = 45)
    private String nombre;

    @Column(name = "dni", nullable = false, length = 45)
    private String dni;

    @Column(name = "hotel", nullable = false)
    private Integer hotel;

    @Column(name = "vuelo", nullable = false)
    private Integer vuelo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Integer getHotel() {
        return hotel;
    }

    public void setHotel(Integer hotel) {
        this.hotel = hotel;
    }

    public Integer getVuelo() {
        return vuelo;
    }

    public void setVuelo(Integer vuelo) {
        this.vuelo = vuelo;
    }

}