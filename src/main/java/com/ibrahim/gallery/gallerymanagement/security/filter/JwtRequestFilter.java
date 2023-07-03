package com.ibrahim.gallery.gallerymanagement.security.filter;

import com.ibrahim.gallery.gallerymanagement.security.invalidToken.service.InvalidTokenService;
import com.ibrahim.gallery.gallerymanagement.security.service.TokenService;
import com.ibrahim.gallery.gallerymanagement.security.service.impl.CustomUserDetailsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.servlet.HandlerExceptionResolver;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static java.util.Objects.isNull;
import static org.apache.commons.lang3.StringUtils.isEmpty;

@Component
@RequiredArgsConstructor
@Slf4j
public class JwtRequestFilter extends OncePerRequestFilter {

    private final CustomUserDetailsService customUserDetailsService;
    private final TokenService tokenService;
    private final InvalidTokenService invalidTokenService;

    @Autowired
    @Qualifier("handlerExceptionResolver")
    private HandlerExceptionResolver handlerExceptionResolver;

    private static final String BEARER = "Bearer ";
    private static final String INVALID_TOKEN_MESSAGE = "token.invalid.message";


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {

        final String header = request.getHeader(HttpHeaders.AUTHORIZATION);

        if (isEmpty(header) || !header.startsWith(BEARER)) {
            chain.doFilter(request, response);
            return;
        }

        final String token = header.split(" ")[1].trim();

        String username = getUsernameFromToken(token, request, response);

        if (!isNull(username) && isNull(SecurityContextHolder.getContext().getAuthentication())) {

            if (!validateToken(token)) {
                log.error("Invalid token...");
                handlerExceptionResolver.resolveException(request, response, null, new RuntimeException(INVALID_TOKEN_MESSAGE));
                chain.doFilter(request, response);
                return;
            }

            UserDetails userDetails = customUserDetailsService.loadUserByUsername(username);

            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());

            authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }

        chain.doFilter(request, response);
    }


    private String getUsernameFromToken(String token, HttpServletRequest request, HttpServletResponse response) {
        try {
            return tokenService.getUsernameFromToken(token);
        } catch (RuntimeException e) {
            handlerExceptionResolver.resolveException(request, response, null, new RuntimeException(INVALID_TOKEN_MESSAGE));
        }
        return null;
    }

    private Boolean validateToken(String token) {
        return !tokenService.isTokenExpired(token) && !invalidTokenService.existsByToken(token);
    }

}
