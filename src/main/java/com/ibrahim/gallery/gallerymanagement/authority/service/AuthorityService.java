package com.ibrahim.gallery.gallerymanagement.authority.service;

import com.ibrahim.gallery.gallerymanagement.authority.entity.Authority;
import com.ibrahim.gallery.gallerymanagement.authority.repository.AuthorityRepository;
import com.ibrahim.gallery.gallerymanagement.common.constants.ExceptionConstants;
import com.ibrahim.gallery.gallerymanagement.common.util.BaseDTOUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class AuthorityService  {

    private final AuthorityRepository authorityRepository;


    @CacheEvict(value = "claims", allEntries = true)
    public Authority save(Authority authority) {
        return authorityRepository.saveAndFlush(authority);
    }

    public Authority get(String authorityId) {
        return authorityRepository.findById(authorityId).orElseThrow(() -> new NoSuchElementException(ExceptionConstants.NOT_FOUND));
    }

    @CacheEvict(value = "claims", allEntries = true)
    public Authority put(String authorityId, Authority authority) {

        Authority existClaim = get(authorityId);

        BaseDTOUtil.setBaseEntityProperty(existClaim, authority);
        authority.setId(existClaim.getId());

        return save(authority);
    }

    public boolean delete(String authorityId) {
        authorityRepository.deleteById(authorityId);
        return Boolean.TRUE;
    }

    public List<Authority> findAll() {
        return authorityRepository.findAll();
    }

}
