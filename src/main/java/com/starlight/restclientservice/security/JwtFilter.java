package com.starlight.restclientservice.security;

import com.starlight.restclientservice.exception.JwtAuthenticationException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@Component
@RequiredArgsConstructor
public class JwtFilter extends GenericFilterBean {

    private final JwtTokenProvider jwtTokenProvider;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        String token = jwtTokenProvider.resolveToken((HttpServletRequest) request);
        try {

            if (token != null && jwtTokenProvider.isTokenValid(token)) {
                Authentication authentication = jwtTokenProvider.getAuthentication(token);
                log.info("Authentication created.");
                if (authentication != null) {
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                }
            }
        } catch (JwtAuthenticationException e) {
            log.info("Do filter: Jwt token is invalid or expired.");
            SecurityContextHolder.clearContext();
            ((HttpServletResponse) response).sendError(e.getHttpStatus().value());
        }

        chain.doFilter(request, response);

    }
}
