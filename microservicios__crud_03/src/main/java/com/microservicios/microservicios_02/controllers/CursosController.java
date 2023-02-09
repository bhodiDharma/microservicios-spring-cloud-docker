package com.microservicios.microservicios_02.controllers;


import com.microservicios.microservicios_02.model.Curso;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@RestController
public class CursosController {



    private List<Curso> cursos;

    @PostConstruct
    public void init() {
        cursos = new ArrayList<>();
        cursos.add(new Curso("Spring", 25, "tarde"));
        cursos.add(new Curso("Spring Boot", 20, "tarde"));
        cursos.add(new Curso("Python", 45, "mañana"));
        cursos.add(new Curso("Java EE", 50, "tarde"));
        cursos.add(new Curso("Java Básico", 80, "tarde"));
    }


    @GetMapping(value = "cursos", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Curso> getCursos() {
        return cursos;
    }

    @GetMapping(value = "cursos/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Curso> buscarCursos(@PathVariable("name") String nombre) {
        List<Curso> cursosMatched = cursos.stream()
                .filter(p -> p.getNombre().contains(nombre))
                .toList();

        return cursosMatched;
    }

    @GetMapping(value="curso", produces = MediaType.APPLICATION_JSON_VALUE)
    public Curso getCurso() {
        return new Curso("Java", 100, "Mañana");
    }


    @DeleteMapping(value = "curso/{name}")
    public void deleteCurso(@PathVariable(name = "name") String name){
        cursos.removeIf(p -> p.getNombre().equals(name));
    }

    @PostMapping(value = "curso", consumes = MediaType.APPLICATION_JSON_VALUE,
                    produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Curso> altaCurso(@RequestBody Curso curso) {
        cursos.add(curso);
        return cursos;
    }

    @PutMapping(value = "curso", consumes = MediaType.APPLICATION_JSON_VALUE,
                    produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Curso> updateCurso(@RequestBody Curso curso){
        for(int i = 0; i < cursos.size(); i++){
            if(cursos.get(i).getNombre().equals(curso.getNombre())){
                cursos.set(i, curso);
            }
        }

        return cursos;

    }


}
