package com.ibrahim.gallery.gallerymanagement.user.entity;

import com.ibrahim.gallery.gallerymanagement.common.entity.BaseEntity;
import com.ibrahim.gallery.gallerymanagement.role.entity.Role;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@Table(name = "USERS")
@Entity
public class User extends BaseEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = -7714517341931883905L;

    @Id
    @GeneratedValue(generator = "USER_SEQ_GEN", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "USER_SEQ_GEN", sequenceName = "USER_SEQ", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;

    private String email;

    private String password;

    private String firstName;

    private String lastName;

    @ManyToMany
    @JoinTable(name = "USER_ROLE",
    joinColumns = { @JoinColumn(name = "USER_ID", referencedColumnName = "id") },
    inverseJoinColumns = { @JoinColumn(name = "ROLE_ID", referencedColumnName = "id") },
    indexes = {
            @Index(name = "USER_INDEX", columnList = "USER_ID"),
            @Index(name = "ROLE_INDEX", columnList = "ROLE_ID")
    })
    private Set<Role> roles;


}
