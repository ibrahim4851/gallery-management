package com.ibrahim.gallery.gallerymanagement.security.service;

import com.ibrahim.gallery.gallerymanagement.common.repo.BaseRepository;
import com.ibrahim.gallery.gallerymanagement.common.service.BaseService;
import com.ibrahim.gallery.gallerymanagement.security.entity.Authority;
import com.ibrahim.gallery.gallerymanagement.security.repo.AuthorityRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthorityService extends BaseService<Authority, Long> {

    private final AuthorityRepository authorityRepository;

    @Override
    public BaseRepository<Authority, Long> getRepository() {
        return authorityRepository;
    }
}
