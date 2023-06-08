package com.ibrahim.gallery.gallerymanagement.security.repo;

import com.ibrahim.gallery.gallerymanagement.common.repo.BaseRepository;
import com.ibrahim.gallery.gallerymanagement.security.entity.User;

import java.util.Optional;

public interface UserRepository extends BaseRepository<User, Long> {

    Optional<User> findByEmail(String email);

}
