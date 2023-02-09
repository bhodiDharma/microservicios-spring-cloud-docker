package com.microservicios.microservicios_contactos_04.securityConfig;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    //definicion roles y usuarios

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{

        //Definicion de Roles y Usuarios

        auth
         .inMemoryAuthentication()
         .withUser("user1")
                .password("{noop}user1") // NOOP se usa para no obligar a usar encriptacion
                .roles("USER")
                .and()
         .withUser("admin")
                .password("{noop}admin")
                .roles("USER", "ADMIN");

        //SI SE QUIRE ENCRIPTACION PARA EL PASSWORD

        /*
          auth
         .inMemoryAuthentication()
         .withUser("user1")
                .password("new BCryptPasswordEncoder().encode("user1"))
                .roles("USER")
                .and()
         .withUser("admin")
                .password("new BCryptPasswordEncoder().encode("admin"))
                .roles("USER", "ADMIN");

         */

        //Si los usuarios estan en una base de datos

        /*
        auth.jdbcAuthentication().dataSource(dataSource)
                .usersByUsernameQuery("select username, password, enabled"
                    + " from users where username=?")
                .authoritiesByUsernameQuery("select username, authority "
                    + "from authorities where username=?");
        */

    }

    @Override
    protected  void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers(HttpMethod.POST, "/contactos").hasRole("ADMIN")
                .antMatchers("/contactos").authenticated()
                //.antMatchers("/**").authenticated()
                //.antMatchers("/contactos/**").authenticated()
                .and()
                .addFilter( new JWTAuthorizationFilter( authenticationManager() ));

    }


}
