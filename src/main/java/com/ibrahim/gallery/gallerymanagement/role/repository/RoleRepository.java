package com.ibrahim.gallery.gallerymanagement.role.repository;

import com.ibrahim.gallery.gallerymanagement.role.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface RoleRepository extends JpaRepository<Role, String>, JpaSpecificationExecutor<Role> {
}
