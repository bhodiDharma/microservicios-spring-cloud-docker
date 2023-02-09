package com.microservicios.microservicios_contactos_04.securityConfig;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static com.microservicios.microservicios_contactos_04.util.Constants.*;

public class JWTAuthorizationFilter extends BasicAuthenticationFilter {
    public JWTAuthorizationFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
        throws IOException, ServletException {

        String header = req.getHeader( ENCABEZADO );

        if( header == null || !header.startsWith( PREFIJO_TOKEN )) {
            chain.doFilter( req, res );
            return;
        }

        //Obtenemos los datos del usuario a partir del token
        UsernamePasswordAuthenticationToken authentication = getAuthentication(req);
        //la informaicon del usuarios se almacena en el contexto de seguridad
        //para que pueda ser utilizada por Spring Security durante el proceso de autorizacion
        SecurityContextHolder.getContext().setAuthentication( authentication );
        chain.doFilter( req, res);

    }

    private UsernamePasswordAuthenticationToken getAuthentication( HttpServletRequest request) {
        //el token viene en la cabexera de la peticion
        String token = request.getHeader( ENCABEZADO );
        if( token != null) {
            //se procesa el token y se recupera el suario y los roles
            Claims claims = Jwts.parser()
                    .setSigningKey( CLAVE )
                    .parseClaimsJws( token.replace( PREFIJO_TOKEN, "" ))
                    .getBody();

            String user = claims.getSubject();
            List<String> authorities = (List<String>) claims.get( "authorities" );

            if( user != null) {
                //creamos el objeto con la informacion del usuario
                return new UsernamePasswordAuthenticationToken( user, null, authorities.stream()
                                                                                    .map( SimpleGrantedAuthority::new )
                                                                                    .toList());
            }
            return null;
        }
        return null;
    }

}
