package com.ibrahim.gallery.gallerymanagement.security.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;


@Getter
@Setter
@AllArgsConstructor
public class CustomGrantedAuthority implements GrantedAuthority {

    private String authority;


    @Override
    public String getAuthority() {
        return authority;
    }
}
