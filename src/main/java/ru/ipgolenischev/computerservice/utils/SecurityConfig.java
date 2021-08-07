package ru.ipgolenischev.computerservice.utils;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.AnonymousAuthenticationFilter;
import ru.ipgolenischev.computerservice.services.JwtTokenService;

@EnableWebSecurity
@Configuration
class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final JwtTokenService jwtTokenService;
    public SecurityConfig(JwtTokenService jwtTokenService){
        this.jwtTokenService = jwtTokenService;
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.addFilterBefore(new RestFilter(jwtTokenService), AnonymousAuthenticationFilter.class);
    }
}
