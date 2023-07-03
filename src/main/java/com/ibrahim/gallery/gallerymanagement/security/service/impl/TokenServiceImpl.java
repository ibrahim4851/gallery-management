package com.ibrahim.gallery.gallerymanagement.security.service.impl;

import com.ibrahim.gallery.gallerymanagement.common.util.DateUtil;
import com.ibrahim.gallery.gallerymanagement.security.model.CustomUserDetail;
import com.ibrahim.gallery.gallerymanagement.security.service.TokenService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TokenServiceImpl implements TokenService, Serializable {

    public static final long JWT_TOKEN_VALIDITY = 100 * 60 * 60 * 60;
    public static final String ID = "id";
    public static final String NAME = "name";
    public static final String CLAIMS = "claims";
    public static final String ROLES = "roles";


    @Value(value = "GalleryApp")
    private String secret;


    @Override
    public String getUsernameFromToken(String token) {
        return getClaimFromToken(token, Claims::getSubject);
    }

    @Override
    public Date getExpirationDateFromToken(String token) {
        return getClaimFromToken(token, Claims::getExpiration);
    }

    @Override
    public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = getAllClaimsFromToken(token);
        return claimsResolver.apply(claims);
    }

    @Override
    public Claims getAllClaimsFromToken(String token) {
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
    }

    @Override
    public Boolean isTokenExpired(String token) {
        final Date expiration = getExpirationDateFromToken(token);
        return expiration.before(new Date());
    }

    @Override
    public String generateToken(Authentication authentication) {

        CustomUserDetail userDetail = (CustomUserDetail) authentication.getPrincipal();

        Date nowDate = DateUtil.getNowDate();

        return Jwts.builder()
                .claim(ID, userDetail.getId())
                .claim(NAME, userDetail.getName())
                .claim(CLAIMS, getClaims(userDetail))
                .claim(ROLES, userDetail.getRoles())
                .setSubject(userDetail.getUsername())
                .setIssuedAt(nowDate)
                .setExpiration(new Date(nowDate.getTime() + JWT_TOKEN_VALIDITY * 1000))
                .signWith(SignatureAlgorithm.HS512, secret).compact();
    }

    private List<String> getClaims(CustomUserDetail userDetail) {
        return userDetail.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());
    }

}
