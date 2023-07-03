package com.ibrahim.gallery.gallerymanagement.security.service;

import io.jsonwebtoken.Claims;
import org.springframework.security.core.Authentication;

import java.util.Date;
import java.util.function.Function;

public interface TokenService {

    String getUsernameFromToken(String token);

    Date getExpirationDateFromToken(String token);

    <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver);

    Claims getAllClaimsFromToken(String token);

    Boolean isTokenExpired(String token);

    String generateToken(Authentication authentication);

}
