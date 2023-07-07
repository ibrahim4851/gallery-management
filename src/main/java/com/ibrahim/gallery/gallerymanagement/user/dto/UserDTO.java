package com.ibrahim.gallery.gallerymanagement.user.dto;

import com.ibrahim.gallery.gallerymanagement.common.dto.BaseDTO;
import com.ibrahim.gallery.gallerymanagement.role.entity.Role;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class UserDTO extends BaseDTO {

    private Long id;

    private String email;

    private String password;

    private String firstName;

    private String lastName;

    private Set<Role> roles;

}
