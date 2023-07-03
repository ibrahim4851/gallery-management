package com.ibrahim.gallery.gallerymanagement.authority.repository;

import com.ibrahim.gallery.gallerymanagement.authority.entity.Authority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface AuthorityRepository extends JpaRepository<Authority, String>, JpaSpecificationExecutor<Authority> {
}
