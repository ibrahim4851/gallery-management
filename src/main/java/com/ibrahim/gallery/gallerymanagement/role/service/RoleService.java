package com.ibrahim.gallery.gallerymanagement.role.service;

import com.ibrahim.gallery.gallerymanagement.common.util.BaseDTOUtil;
import com.ibrahim.gallery.gallerymanagement.role.entity.Role;
import com.ibrahim.gallery.gallerymanagement.role.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RoleService  {

    private final RoleRepository roleRepository;

    public Optional<Role> findById(String roleId) {
        return roleRepository.findById(roleId);
    }

    @CacheEvict(value = "roles", allEntries = true)
    public boolean delete(String roleId) {
        roleRepository.deleteById(roleId);
        return Boolean.TRUE;
    }

    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    @CacheEvict(value = "roles", allEntries = true)
    public Role save(Role role) {
        findById(role.getId()).ifPresent(registeredRole -> BaseDTOUtil.setBaseEntityProperty(registeredRole, role));
        Role newRole = roleRepository.saveAndFlush(role);
        return newRole;
    }

}
