package com.ibrahim.gallery.gallerymanagement.security.service;

import com.ibrahim.gallery.gallerymanagement.common.repo.BaseRepository;
import com.ibrahim.gallery.gallerymanagement.common.service.BaseService;
import com.ibrahim.gallery.gallerymanagement.security.entity.Role;
import com.ibrahim.gallery.gallerymanagement.security.repo.RoleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RoleService extends BaseService<Role, Long> {

    private final RoleRepository roleRepository;

    @Override
    public BaseRepository<Role, Long> getRepository() {
        return roleRepository;
    }
}
