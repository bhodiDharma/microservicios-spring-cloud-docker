package com.microservicios.microservicios_02;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class Microservicios02ApplicationTests {

	@Autowired
	MockMvc mock;

	@Test
	@Order(0)
	void eliminarCurso() throws Exception {
		mock.perform(delete("/curso/Python"));
	}

	@Test
	@Order(1)
	void testCursos() throws Exception {
		mock.perform(get("/cursos")).andDo(print());
	}

	@Test
	@Order(2)
	void testAlta() throws Exception {
		mock.perform(post("/curso")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{\"nombre\":\"Angular 10\",\"duracion\":40,\"horario\":\"tarde\"}"))
				.andDo(print());
	}

	@Test
	@Order(3)
	void testActualizacion() throws Exception {
		mock.perform(put("/curso")
						.contentType(MediaType.APPLICATION_JSON)
						.content("{\"nombre\":\"Angular 10\",\"duracion\":80,\"horario\":\"mañana\"}"))
				.andDo(print());
	}

}
