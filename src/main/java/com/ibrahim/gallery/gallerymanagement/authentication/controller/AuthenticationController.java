package com.ibrahim.gallery.gallerymanagement.authentication.controller;

import com.ibrahim.gallery.gallerymanagement.authentication.dto.Login;
import com.ibrahim.gallery.gallerymanagement.authentication.dto.LoginDTO;
import com.ibrahim.gallery.gallerymanagement.authentication.dto.LogoutDTO;
import com.ibrahim.gallery.gallerymanagement.authentication.service.AuthenticationService;
import com.ibrahim.gallery.gallerymanagement.security.service.impl.SecurityContextService;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@RestController
@RequestMapping("/v1/authentication")
public class AuthenticationController  {

    private final AuthenticationService authenticationService;

    public AuthenticationController( AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }


    @PostMapping(value = "/login")
    public Login login(@Valid @RequestBody LoginDTO authenticationDTO) {
        return authenticationService.login(authenticationDTO);
    }

    @GetMapping(value = "/logout")
    public Boolean logout(HttpServletRequest request) {

        final String header = request.getHeader(HttpHeaders.AUTHORIZATION);

        final String token = header.split(" ")[1].trim();

        LogoutDTO logoutDTO = new LogoutDTO();
        logoutDTO.setUserId(SecurityContextService.getCurrentUserId());
        logoutDTO.setToken(token);

        return authenticationService.logout(logoutDTO);
    }

}
