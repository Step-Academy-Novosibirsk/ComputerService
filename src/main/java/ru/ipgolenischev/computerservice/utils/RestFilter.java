package ru.ipgolenischev.computerservice.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.filter.OncePerRequestFilter;
import ru.ipgolenischev.computerservice.models.base.AbstractServiceUserServiceModel;
import ru.ipgolenischev.computerservice.services.JwtTokenService;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RestFilter extends OncePerRequestFilter {

    private JwtTokenService jwtTokenService;
    public RestFilter(JwtTokenService jwtTokenService){
        this.jwtTokenService = jwtTokenService;
    }
    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        String key = httpServletRequest.getHeader("API-KEY");
        if(key==null || !key.equals("qwerty")) {
            httpServletResponse.sendError(HttpServletResponse.SC_FORBIDDEN);
            return;
        }
        String address = httpServletRequest.getRequestURI();
        if(httpServletRequest.getRequestURI().equals("/api/authorize")) {
            filterChain.doFilter(httpServletRequest,httpServletResponse);
            return;
        }
        String token = httpServletRequest.getHeader("Authorization");
        if(token==null) {
            httpServletResponse.sendError(HttpServletResponse.SC_FORBIDDEN);
            return;
        }
        AbstractServiceUserServiceModel user = jwtTokenService.findUserByToken(token);
        if(user==null){
            httpServletResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }
        filterChain.doFilter(httpServletRequest,httpServletResponse);


    }
}
