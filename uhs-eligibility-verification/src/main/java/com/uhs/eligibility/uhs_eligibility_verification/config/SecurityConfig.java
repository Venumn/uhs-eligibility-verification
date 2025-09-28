package com.uhs.eligibility.uhs_eligibility_verification.config;


import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.web.SecurityFilterChain;

import javax.crypto.SecretKey;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity, JwtDecoder jwtDecoder) throws Exception {

      httpSecurity.csrf(csrf->
              csrf.disable())
              .authorizeHttpRequests(
                      auth->
                              auth.requestMatchers("/api/auth/**").permitAll()
                                      .requestMatchers(HttpMethod.POST, "api/patients").hasRole("ADMIN")
                                      .requestMatchers("/api/patients/**")
                                      .authenticated()
                                      .anyRequest()
                                      .permitAll()
              ).oauth2ResourceServer(oauth2-> oauth2.jwt(
                      jwt-> jwt.decoder(jwtDecoder)
              ));

        return httpSecurity.build();

    }

    @Bean
    public JwtDecoder jwtDecoder(SecretKey jwtSecretKey) {
        return NimbusJwtDecoder.withSecretKey(jwtSecretKey).build();

    }

    @Bean
    public SecretKey jwtSecretKey() {
        return Keys.secretKeyFor(SignatureAlgorithm.HS256);
    }
}
