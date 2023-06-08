package com.ibrahim.gallery.gallerymanagement.security.service;

import com.ibrahim.gallery.gallerymanagement.common.repo.BaseRepository;
import com.ibrahim.gallery.gallerymanagement.common.service.BaseService;
import com.ibrahim.gallery.gallerymanagement.security.entity.User;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
@AllArgsConstructor
public class UserDetailService implements UserDetailsService {

    private final UserService userService;


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userService.findByEmail(email);
    }



}
