package com.ibrahim.gallery.gallerymanagement.security.entity;

import com.ibrahim.gallery.gallerymanagement.common.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serial;
import java.util.Set;

@Getter
@Setter
@Table(name = "auhorities", indexes = @Index(name = "AUTHORITY_ID", columnList = "ID", unique = true))
@Entity
public class Authority extends BaseEntity {

    @Serial
    private static final long serialVersionUID = -4929826633491918621L;

    @Id
    @GeneratedValue(generator = "AUTHORITY_SEQ_GEN", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "AUTHORITY_SEQ_GEN", sequenceName = "AUTHORITY_SEQ", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;

    private String permission;

    @ManyToMany(mappedBy = "authorities")
    private Set<Role> roles;

}
