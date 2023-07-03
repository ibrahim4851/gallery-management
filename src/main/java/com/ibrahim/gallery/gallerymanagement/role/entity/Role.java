package com.ibrahim.gallery.gallerymanagement.role.entity;


import com.ibrahim.gallery.gallerymanagement.authority.entity.Authority;
import com.ibrahim.gallery.gallerymanagement.common.entity.BaseEntity;
import com.ibrahim.gallery.gallerymanagement.user.entity.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serial;
import java.util.Set;

@Getter
@Setter
@Table(name = "ROLES")
@Entity
public class Role extends BaseEntity {

    @Serial
    private static final long serialVersionUID = 8188071218913312497L;

    @Id
    @Column(name = "id", nullable = false, updatable = false)
    private String id;

    @Column(name = "NAME", unique = true)
    private String name;

    @ManyToMany
    @JoinTable(name = "ROLE_AUTHORITIES",
            joinColumns = { @JoinColumn(name = "ROLE_ID", referencedColumnName = "id") },
            inverseJoinColumns = { @JoinColumn(name = "AUTHORITY_ID", referencedColumnName = "id") },
            indexes = {
                    @Index(name = "ROLE_INDEX", columnList = "ROLE_ID"),
                    @Index(name = "AUTHORITY_INDEX", columnList = "AUTHORITY_ID")
            })
    private Set<Authority> authorities;

    @ManyToMany(mappedBy = "roles")
    private Set<User> users;


}
