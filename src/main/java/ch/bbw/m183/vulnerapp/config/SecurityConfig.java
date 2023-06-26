package ch.bbw.m183.vulnerapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http.cors()
        .and()
        .httpBasic()
        .and()
        .csrf()
        .disable()
        .authorizeHttpRequests()
        .requestMatchers(HttpMethod.GET,"/api/blog")
        .permitAll()
        .requestMatchers("/api/**")
        .authenticated()
        .anyRequest()
        .permitAll();

    return http.build();
  }
}
