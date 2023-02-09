package com._microservicios_vuelos.model;

import javax.persistence.*;

@Entity
@Table(name = "vuelos")
public class Vuelo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idvuelo", nullable = false)
    private Integer id;

    @Column(name = "company", nullable = false, length = 45)
    private String company;

    @Column(name = "fecha", nullable = false, length = 45)
    private String fecha;

    @Column(name = "precio", nullable = false)
    private Double precio;

    @Column(name = "plazas", nullable = false)
    private Integer plazas;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Integer getPlazas() {
        return plazas;
    }

    public void setPlazas(Integer plazas) {
        this.plazas = plazas;
    }

}