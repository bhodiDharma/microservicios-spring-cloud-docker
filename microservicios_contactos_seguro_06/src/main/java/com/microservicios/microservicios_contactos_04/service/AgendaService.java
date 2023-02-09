package com.microservicios.microservicios_contactos_04.service;

import com.microservicios.microservicios_contactos_04.model.Contacto;

import java.util.List;

public interface AgendaService {
    boolean agregarContacto(Contacto contacto);
    List<Contacto> recuperarContactos();
    void actualizarContacto(Contacto contacto);
    boolean eliminarContacto(int idContacto);
    Contacto buscarContacto(int idContacto);
}
