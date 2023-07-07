package com.ibrahim.gallery.gallerymanagement.user.service;

import com.ibrahim.gallery.gallerymanagement.common.constants.ExceptionConstants;
import com.ibrahim.gallery.gallerymanagement.common.repo.BaseRepository;
import com.ibrahim.gallery.gallerymanagement.common.service.BaseService;
import com.ibrahim.gallery.gallerymanagement.common.validator.EmailValidator;
import com.ibrahim.gallery.gallerymanagement.security.config.PasswordEncoderConfiguration;
import com.ibrahim.gallery.gallerymanagement.user.entity.User;
import com.ibrahim.gallery.gallerymanagement.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService extends BaseService<User, Long> {

    private final UserRepository userRepository;
    private final EmailValidator emailValidator;
    private final PasswordEncoderConfiguration passwordEncoderConfiguration;

    @Override
    public BaseRepository getRepository() {
        return userRepository;
    }

    public Optional<User> findByEmailWithRelations(String username) {
        return userRepository.findByEmailWithRelations(username);
    }

    public User register(User user){

        boolean isValidEmail = emailValidator.
                test(user.getEmail());

        if (!isValidEmail) {
            throw new IllegalStateException(ExceptionConstants.NOT_VALID_MAIL);
        }

        boolean userExists = userRepository
                .findByEmail(user.getEmail())
                .isPresent();

        if (userExists) {
            throw new IllegalStateException(ExceptionConstants.USER_ALREADY_EXIST);
        }

        user.setPassword(passwordEncoderConfiguration.passwordEncoder().encode(user.getPassword()));

        return userRepository.save(user);
    }

}
