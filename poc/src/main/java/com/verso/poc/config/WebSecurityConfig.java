package com.verso.poc.config;

import com.verso.poc.util.JWTAuthorizationFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;

@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
@Configuration
@Component
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private JWTAuthorizationFilter authorizationFilter;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf()
                .disable()
                .addFilterAfter(authorizationFilter, UsernamePasswordAuthenticationFilter.class)
                .authorizeRequests()
                //.antMatchers("v1/api/**")
                //.authenticated()
                .anyRequest().permitAll();
    }

    public WebSecurityConfig(JWTAuthorizationFilter authorizationFilter) {
        this.authorizationFilter = authorizationFilter;
    }
}