package com.microservicios.microservicios_contactos_04.controller;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.stream.Collectors;

import static com.microservicios.microservicios_contactos_04.util.Constants.CLAVE;
import static com.microservicios.microservicios_contactos_04.util.Constants.TIEMPO_VIDA;

@RestController
public class AuthController {

    AuthenticationManager authManager;

    public AuthController(AuthenticationManager authManager){
        this.authManager = authManager;
    }


    @PostMapping("loggin")
    public String login(@RequestParam("user") String user, @RequestParam("pwd") String pwd){
        Authentication autenticacion = authManager.authenticate(new UsernamePasswordAuthenticationToken(user, pwd));

        //Si el usuario esta autenticado se genera el token

        if(autenticacion.isAuthenticated()) {

            return getToken(autenticacion);
        } else {
            return "no autenticado";
        }
    }

    private String getToken(Authentication autentication) {
        //en el body del token se incluyen el usuario
        //y los roles a los que pertenece, además
        //de la fecha de caducidad y los datos de la firma

        String token = Jwts.builder()
                .setIssuedAt(new Date()) //fecha de creacion
                .setSubject(autentication.getName()) //usuario
                .claim("authorities", autentication.getAuthorities().stream()
                                        .map(GrantedAuthority::getAuthority)
                                        .collect(Collectors.toList())) //ROLES
                .setExpiration(new Date(System.currentTimeMillis() + TIEMPO_VIDA)) //Fecha caducidad
                .signWith(SignatureAlgorithm.HS512, CLAVE)
                .compact(); //clave y algoritmo para la firma

        return token;
    }
}
