package com.microservicios.microservicios_contactos_04.dao;

import com.microservicios.microservicios_contactos_04.model.Contacto;

import java.util.List;

public interface AgendaDao {

    void agregarContacto(Contacto contacto);

    Contacto recuperarContacto(String email);

    void eliminarContacto(String email);

    List<Contacto> devolverContactos();

    void eliminarContacto(int idContacto);

    Contacto recuperarContacto(int idContacto);

    void actualizarContacto(Contacto contacto);
}
