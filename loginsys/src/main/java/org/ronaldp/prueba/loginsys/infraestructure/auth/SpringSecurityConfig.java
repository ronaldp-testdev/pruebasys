package org.ronaldp.prueba.loginsys.infraestructure.auth;


import org.ronaldp.prueba.loginsys.infraestructure.auth.filter.JwtAuthenticationFilter;
import org.ronaldp.prueba.loginsys.infraestructure.auth.filter.JwtValidationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.lang.reflect.Array;
import java.util.Arrays;
@Configuration
public class SpringSecurityConfig {
    @Autowired
    private AuthenticationConfiguration authenticationConfiguration;

    @Bean
    AuthenticationManager authenticationManager() throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    //$2a$10$DOMDxjYyfZ/e7RcBfUpzqeaCs8pLgcizuiQWXPkU35nOhZlFcE9MS   //12345
    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http.authorizeHttpRequests(authz ->
                        authz
                                .requestMatchers(HttpMethod.GET,"/api/personas", "/api/personas/pagina").permitAll()
                                .requestMatchers(HttpMethod.GET, "/api/personas/{id}").permitAll()
                                .requestMatchers(HttpMethod.POST,"/api/personas").permitAll()
                                .requestMatchers(HttpMethod.POST,"/api/personas/csv").permitAll()
                                .requestMatchers(HttpMethod.PUT, "/api/personas/{id}").permitAll()
                                .requestMatchers(HttpMethod.DELETE, "/api/personas/{id}").permitAll()

                                .requestMatchers(HttpMethod.GET,"/api/usuarios", "/api/usuarios/pagina").permitAll()
                                .requestMatchers(HttpMethod.GET, "/api/usuarios/{id}").permitAll()
                                .requestMatchers(HttpMethod.POST,"/api/usuarios").permitAll()
                                .requestMatchers(HttpMethod.PUT, "/api/usuarios/{id}").permitAll()


                                .requestMatchers(HttpMethod.GET,"/api/roles", "/api/roles/pagina").permitAll()
                                .requestMatchers(HttpMethod.GET, "/api/roles/{id}").permitAll()
                                .requestMatchers(HttpMethod.POST,"/api/roles").permitAll()
                                .requestMatchers(HttpMethod.PUT, "/api/roles/{id}").permitAll()
                                .requestMatchers(HttpMethod.DELETE, "/api/roles/{id}").permitAll()


                                .requestMatchers(HttpMethod.GET,"/api/rol-opciones", "/api/rol-opciones/pagina").permitAll()
                                .requestMatchers(HttpMethod.GET, "/api/rol-opciones/{id}").permitAll()
                                .requestMatchers(HttpMethod.POST,"/api/rol-opciones").permitAll()
                                .requestMatchers(HttpMethod.PUT, "/api/rol-opciones/{id}").permitAll()
                                .requestMatchers(HttpMethod.DELETE, "/api/rol-opciones/{id}").permitAll()

                                .requestMatchers(HttpMethod.GET,"/api/sessions", "/api/sessions/pagina").permitAll()
                                .requestMatchers(HttpMethod.GET, "/api/sessions/{id}").permitAll()
                                .requestMatchers(HttpMethod.GET, "/api/sessions/ultima/{userid}").permitAll()

                                .requestMatchers(HttpMethod.POST,"/api/sessions").permitAll()
                                .requestMatchers(HttpMethod.PUT, "/api/sessions/{id}").permitAll()
                                .requestMatchers(HttpMethod.DELETE, "/api/sessions/{id}").permitAll()



                                .requestMatchers(HttpMethod.GET,"/api/users", "/api/users/page/{page}").permitAll()
                                .requestMatchers(HttpMethod.GET, "/api/users/{id}").hasAnyRole("USER", "ADMIN")
                                .requestMatchers(HttpMethod.POST, "/api/users").hasRole("ADMIN")
                                .requestMatchers(HttpMethod.PUT, "/api/users/{id}").hasRole("ADMIN")
                                .requestMatchers(HttpMethod.DELETE, "/api/users/{id}").hasRole("ADMIN")
                                .anyRequest().authenticated())
                //CORS Configuration
                .cors(cors -> cors.configurationSource(configurationSource()))
                //Filtro de la clase JwtAuthenticationFilter
                .addFilter(new JwtAuthenticationFilter(authenticationManager()))
                .addFilter(new JwtValidationFilter(authenticationManager()))
                .csrf(config -> config.disable())
                .sessionManagement(management -> management.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .build();
    }
    @Bean
    CorsConfigurationSource configurationSource(){
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowedOriginPatterns(Arrays.asList("*"));
        config.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
        config.setAllowedMethods(Arrays.asList("POST", "GET", "PUT", "DELETE"));
        config.setAllowedHeaders(Arrays.asList("Authorization", "Content-Type"));
        config.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);
        return source;
    }

    @Bean
    FilterRegistrationBean<CorsFilter> corsFilter(){
        FilterRegistrationBean<CorsFilter> corsBean = new FilterRegistrationBean<CorsFilter>(
                new CorsFilter(this.configurationSource()));
        corsBean.setOrder(Ordered.HIGHEST_PRECEDENCE);
        return corsBean;
    }
}
