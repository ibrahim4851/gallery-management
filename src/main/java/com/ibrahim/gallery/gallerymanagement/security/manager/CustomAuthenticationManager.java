package com.ibrahim.gallery.gallerymanagement.security.manager;

import com.ibrahim.gallery.gallerymanagement.security.model.CustomUserDetail;
import com.ibrahim.gallery.gallerymanagement.security.service.impl.CustomUserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
@RequiredArgsConstructor
public class CustomAuthenticationManager implements AuthenticationManager {

    private final CustomUserDetailsService customUserDetailsService;
    private final PasswordEncoder passwordEncoder;

    public static final String BAD_CREDENTIALS = "authentication.bad.credentials";
    public static final String USERNAME_NOT_FOUND = "authentication.username.not.found";
    public static final String USER_ACCOUNT_LOCKED = "authentication.user.account.locked";
    public static final String USER_ACCOUNT_DISABLED = "authentication.user.account.disabled";
    public static final String USER_ACCOUNT_EXPIRED = "authentication.user.account.expired";
    public static final String USER_CREDENTIALS_EXPIRED = "authentication.user.credentials.expired";


    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        String email = authentication.getPrincipal().toString();
        String password = authentication.getCredentials().toString();

        CustomUserDetail userDetails = customUserDetailsService.loadUserByUsername(email);

        if (Objects.isNull(userDetails)) {
            throw new UsernameNotFoundException(USERNAME_NOT_FOUND);
        }

        if (!passwordEncoder.matches(password, userDetails.getPassword())) {
            throw new BadCredentialsException(BAD_CREDENTIALS);
        }

        check(userDetails);

        return new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
    }

    private void check(UserDetails userDetails) {

        if (!userDetails.isAccountNonLocked()) {
            throw new LockedException(USER_ACCOUNT_LOCKED);
        }

        if (!userDetails.isEnabled()) {
            throw new DisabledException(USER_ACCOUNT_DISABLED);
        }

        if (!userDetails.isAccountNonExpired()) {
            throw new AccountExpiredException(USER_ACCOUNT_EXPIRED);
        }

        if (!userDetails.isCredentialsNonExpired()) {
            throw new CredentialsExpiredException(USER_CREDENTIALS_EXPIRED);
        }
    }

}
