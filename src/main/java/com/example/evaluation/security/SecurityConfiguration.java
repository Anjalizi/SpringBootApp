package com.example.evaluation.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
            .passwordEncoder(new BCryptPasswordEncoder())
                .withUser("user")
                .password("$2a$10$xcKF5IlgILKJSaI8aWWfIu2BdEaehabAoNJ0OOziMubHaKqDKjm1m")
                .roles("USER")
            .and()
                .withUser("admin")
                .password("$2a$10$xcKF5IlgILKJSaI8aWWfIu2BdEaehabAoNJ0OOziMubHaKqDKjm1m")
                .roles("ADMIN")
            ;
    }
 
    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	// most restrictive to least restrictive
        http.httpBasic()
        	.and().authorizeRequests()
            .antMatchers(HttpMethod.POST, "/users").hasRole("USER")
            .antMatchers("/").permitAll()
            .and().csrf().disable(); 
    }  
}
