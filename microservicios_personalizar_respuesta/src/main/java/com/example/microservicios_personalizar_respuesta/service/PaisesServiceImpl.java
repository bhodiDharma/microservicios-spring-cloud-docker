package com.example.microservicios_personalizar_respuesta.service;


import com.example.microservicios_personalizar_respuesta.model.Pais;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class PaisesServiceImpl implements PaisesService {


    @Autowired
    RestTemplate template;

    String url = "https://restcountries.com/v2/all";

    @Override
    public List<Pais> obtenerPaises() {
        String resultado = template.getForObject(url, String.class);
        ObjectMapper maper = new ObjectMapper();
        List<Pais> paises = new ArrayList<>();
        ArrayNode array;

        try {
            array = (ArrayNode)maper.readTree(resultado);

            for(Object o:array){
                ObjectNode json = (ObjectNode) o;
                paises.add(new Pais(json.get( "name" ).asText(),
                                    json.has( "capital" ) ?
                                    json.get( "capital" ).asText() : "No Capital Bitches",
                                    json.get( "population" ).asText()));
            }
        } catch (JsonMappingException e) {
            throw new RuntimeException(e);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        return paises;

    }

    @Override
    public List<Pais> buscarPaises(String name) {
        return obtenerPaises().stream()
                .filter( p -> p.getNombre().contains(name))
                .toList();
    }
}
