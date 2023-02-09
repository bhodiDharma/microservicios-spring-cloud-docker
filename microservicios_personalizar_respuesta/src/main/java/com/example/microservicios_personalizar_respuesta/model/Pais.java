package com.example.microservicios_personalizar_respuesta.model;

public class Pais {


    private String nombre;
    private String capital;

    private String poblacion;

    public Pais() {
    }

    public Pais(String nombre, String capital,  String poblacion) {
        this.nombre = nombre;
        this.capital = capital;

        this.poblacion = poblacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }



    public String getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(String poblacion) {
        this.poblacion = poblacion;
    }
}
