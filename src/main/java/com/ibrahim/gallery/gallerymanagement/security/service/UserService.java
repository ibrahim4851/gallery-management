package com.ibrahim.gallery.gallerymanagement.security.service;

import com.ibrahim.gallery.gallerymanagement.common.repo.BaseRepository;
import com.ibrahim.gallery.gallerymanagement.common.service.BaseService;
import com.ibrahim.gallery.gallerymanagement.security.entity.User;
import com.ibrahim.gallery.gallerymanagement.security.repo.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.ibrahim.gallery.gallerymanagement.common.constants.ExceptionConstants.USER_NOT_FOUND;

@Service
@AllArgsConstructor
public class UserService  extends BaseService<User, Long> {

    private final UserRepository userRepository;

    @Override
    public BaseRepository<User, Long> getRepository() {
        return userRepository;
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email).orElseThrow(()->new UsernameNotFoundException(USER_NOT_FOUND));
    }

}
