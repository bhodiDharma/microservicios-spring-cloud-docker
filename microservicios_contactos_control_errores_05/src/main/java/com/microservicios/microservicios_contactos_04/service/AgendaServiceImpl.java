package com.microservicios.microservicios_contactos_04.service;

import com.microservicios.microservicios_contactos_04.dao.AgendaDao;
import com.microservicios.microservicios_contactos_04.model.Contacto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AgendaServiceImpl implements AgendaService{

    @Autowired
    AgendaDao dao;


    @Override
    public void agregarContacto(Contacto contacto) throws Exception {
        if(dao.recuperarContacto(contacto.getEmail()) == null) {
            dao.agregarContacto(contacto);

            return;
        }

        throw new Exception("Contacto ya existente");
    }

    @Override
    public List<Contacto> recuperarContactos() {
        return dao.devolverContactos();
    }

    @Override
    public void actualizarContacto(Contacto contacto) {
        if(dao.recuperarContacto(contacto.getId()) != null) {
            dao.actualizarContacto(contacto);
        }
    }

    @Override
    public boolean eliminarContacto(int idContacto) {
        if(dao.recuperarContacto( idContacto ) != null) {
            dao.eliminarContacto( idContacto );
            return true;
        }
        return false;
    }

    @Override
    public Contacto buscarContacto(int idContacto) {
        return dao.recuperarContacto( idContacto );
    }
}
