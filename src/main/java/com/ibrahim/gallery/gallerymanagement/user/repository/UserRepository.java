package com.ibrahim.gallery.gallerymanagement.user.repository;

import com.ibrahim.gallery.gallerymanagement.common.repo.BaseRepository;
import com.ibrahim.gallery.gallerymanagement.user.entity.User;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends BaseRepository<User, Long> {

    @Query("SELECT u from User u" +
            " LEFT JOIN FETCH u.roles roles" +
            " LEFT JOIN FETCH roles.authorities authorities" +
            " WHERE u.email =:email")
    Optional<User> findByEmailWithRelations(String email);

    Optional<User> findByEmail(String email);
}
