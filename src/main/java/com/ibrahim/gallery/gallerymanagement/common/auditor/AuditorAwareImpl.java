package com.ibrahim.gallery.gallerymanagement.common.auditor;

import com.ibrahim.gallery.gallerymanagement.security.service.impl.SecurityContextService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;

import java.util.Objects;
import java.util.Optional;

@RequiredArgsConstructor
public class AuditorAwareImpl implements AuditorAware<String> {

    private static final String ANONYMOUS_USER = "anonymousUser";


    @Override
    public Optional<String> getCurrentAuditor() {

        Authentication authentication = SecurityContextService.getAuthentication();

        if (Objects.isNull(authentication) || !authentication.isAuthenticated()) {
            return Optional.empty();
        }

        if (ANONYMOUS_USER.equals(authentication.getPrincipal())) {
            return Optional.of(authentication.getPrincipal().toString());
        }

        return Optional.of(SecurityContextService.getPrincipal().getId().toString());
    }
}
