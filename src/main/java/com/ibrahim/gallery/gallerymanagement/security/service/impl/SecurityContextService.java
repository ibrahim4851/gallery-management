package com.ibrahim.gallery.gallerymanagement.security.service.impl;

import com.ibrahim.gallery.gallerymanagement.security.model.CustomUserDetail;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Objects;

public class SecurityContextService {

    public static Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }

    public static CustomUserDetail getPrincipal() {
        try {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            return (CustomUserDetail) authentication.getPrincipal();
        } catch (Exception exception) {
            return null;
        }
    }

    public static Long getCurrentUserId() {

        CustomUserDetail principal = getPrincipal();

        if (Objects.nonNull(principal)) {
            return getPrincipal().getId().longValue();
        }

        return null;
    }

    public static Boolean hasRole(String roleId) {

        CustomUserDetail principal = getPrincipal();

        if (Objects.nonNull(principal)) {
            return principal.getRoles().stream().anyMatch(role -> role.equals(roleId));
        }

        return false;
    }

    public static Boolean hasClaim(String claimId) {

        CustomUserDetail principal = getPrincipal();

        if (Objects.nonNull(principal)) {
            return principal.getAuthorities().stream()
                    .map(GrantedAuthority::getAuthority)
                    .anyMatch(claim -> claim.equals(claimId));
        }

        return false;
    }

}
