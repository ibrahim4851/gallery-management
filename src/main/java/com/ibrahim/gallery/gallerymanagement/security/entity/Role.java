package com.ibrahim.gallery.gallerymanagement.security.entity;


import com.ibrahim.gallery.gallerymanagement.common.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serial;
import java.util.Set;

@Getter
@Setter
@Table(name = "ROLES", indexes = @Index(name = "ROLE_ID", columnList = "ID", unique = true))
@Entity
public class Role extends BaseEntity {

    @Serial
    private static final long serialVersionUID = 8188071218913312497L;

    @Id
    @GeneratedValue(generator = "ROLE_SEQ_GEN", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "ROLE_SEQ_GEN", sequenceName = "ROLE_SEQ", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;

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
