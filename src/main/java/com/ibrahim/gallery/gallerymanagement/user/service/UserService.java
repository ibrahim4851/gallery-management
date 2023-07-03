package com.ibrahim.gallery.gallerymanagement.user.service;

import com.ibrahim.gallery.gallerymanagement.common.repo.BaseRepository;
import com.ibrahim.gallery.gallerymanagement.common.service.BaseService;
import com.ibrahim.gallery.gallerymanagement.user.entity.User;
import com.ibrahim.gallery.gallerymanagement.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService extends BaseService<User, Long> {

    private final UserRepository userRepository;

    @Override
    public BaseRepository getRepository() {
        return null;
    }

    public Optional<User> findByEmailWithRelations(String username) {
        return userRepository.findByEmailWithRelations(username);
    }


}
