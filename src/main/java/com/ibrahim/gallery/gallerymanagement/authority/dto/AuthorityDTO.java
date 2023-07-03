package com.ibrahim.gallery.gallerymanagement.authority.dto;

import com.ibrahim.gallery.gallerymanagement.common.dto.BaseDTO;
import com.ibrahim.gallery.gallerymanagement.role.entity.Role;

import java.util.Set;

public class AuthorityDTO extends BaseDTO {

    private String id;

    private String permission;

    private Set<Role> roles;

}
