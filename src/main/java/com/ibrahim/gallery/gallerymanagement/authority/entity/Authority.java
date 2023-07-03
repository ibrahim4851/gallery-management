package com.ibrahim.gallery.gallerymanagement.authority.entity;

import com.ibrahim.gallery.gallerymanagement.common.entity.BaseEntity;
import com.ibrahim.gallery.gallerymanagement.role.entity.Role;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serial;
import java.util.Set;

@Getter
@Setter
@Table(name = "auhorities")
@Entity
public class Authority extends BaseEntity {

    @Serial
    private static final long serialVersionUID = -4929826633491918621L;

    @Id
    @Column(name = "id", nullable = false, updatable = false)
    private String id;

    private String permission;

    @ManyToMany(mappedBy = "authorities")
    private Set<Role> roles;

}
