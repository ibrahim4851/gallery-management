package com.ibrahim.gallery.gallerymanagement.security.service.impl;

import com.ibrahim.gallery.gallerymanagement.role.entity.Role;
import com.ibrahim.gallery.gallerymanagement.security.model.CustomGrantedAuthority;
import com.ibrahim.gallery.gallerymanagement.security.model.CustomUserDetail;
import com.ibrahim.gallery.gallerymanagement.user.entity.User;
import com.ibrahim.gallery.gallerymanagement.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserService userService;


    @Override
    public CustomUserDetail loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<User> optionalUser = userService.findByEmailWithRelations(username);

        if (optionalUser.isEmpty()) {
            return null;
        }

        return getUserDetails(optionalUser.get());
    }

    private CustomUserDetail getUserDetails(User user) {

        CustomUserDetail accountDetail = new CustomUserDetail();

        accountDetail.setId(user.getId());
        accountDetail.setUsername(user.getEmail());
        accountDetail.setName(user.getFirstName());
        accountDetail.setPassword(user.getPassword());
        accountDetail.setRoles(getRoles(user.getRoles()));
        accountDetail.setEnabled(true);
        accountDetail.setAccountNonExpired(true);
        accountDetail.setCredentialsNonExpired(true);
        accountDetail.setAccountNonLocked(true);
        accountDetail.setAuthorities(getAuthorities(user.getRoles()));

        return accountDetail;
    }

    private Set<CustomGrantedAuthority> getAuthorities(Set<Role> roles) {
        return roles.stream()
                .flatMap(role -> role.getAuthorities().stream())
                .map(authority -> new CustomGrantedAuthority(authority.getId()))
                .collect(Collectors.toSet());
    }

    private Set<String> getRoles(Set<Role> roles) {
        return roles.stream()
                .map(Role::getId)
                .collect(Collectors.toSet());
    }

}
