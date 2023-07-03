package com.ibrahim.gallery.gallerymanagement.authentication.service;

import com.ibrahim.gallery.gallerymanagement.authentication.dto.Login;
import com.ibrahim.gallery.gallerymanagement.authentication.dto.LoginDTO;
import com.ibrahim.gallery.gallerymanagement.authentication.dto.LogoutDTO;
import com.ibrahim.gallery.gallerymanagement.security.invalidToken.service.InvalidTokenService;
import com.ibrahim.gallery.gallerymanagement.security.manager.CustomAuthenticationManager;
import com.ibrahim.gallery.gallerymanagement.security.service.TokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final CustomAuthenticationManager customAuthenticationManager;
    private final TokenService tokenService;
    private final InvalidTokenService invalidTokenService;


    public Login login(LoginDTO authenticationDTO) {

        Authentication authenticate = customAuthenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationDTO.getUsername(), authenticationDTO.getPassword()));

        String token = tokenService.generateToken(authenticate);

        Login login = new Login();
        login.setToken(token);

        return login;
    }

    public Boolean logout(LogoutDTO logoutDTO) {

        Boolean isInvalidTokenAlreadyExists = invalidTokenService.existsByToken(logoutDTO.getToken());

        if (!isInvalidTokenAlreadyExists) {
            invalidTokenService.save(logoutDTO);
        }

        return Boolean.TRUE;
    }

}
