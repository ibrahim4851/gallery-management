package com.ibrahim.gallery.gallerymanagement.security.invalidToken.entity;

import com.ibrahim.gallery.gallerymanagement.common.entity.BaseEntity;
import com.ibrahim.gallery.gallerymanagement.user.entity.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serial;
import java.util.Date;

@Entity
@Table(name = "INVALID_TOKENS")
@Getter
@Setter
public class InvalidToken extends BaseEntity {

    @Serial
    private static final long serialVersionUID = 12221807143169139L;

    @Id
    @Column(name = "ID", nullable = false, updatable = false)
    @SequenceGenerator(name = "GEN_INVALID_TOKEN", sequenceName = "SEQ_INVALID_TOKEN", allocationSize = 1)
    @GeneratedValue(generator = "GEN_INVALID_TOKEN", strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID")
    private User user;

    @Column(name = "TOKEN", columnDefinition = "TEXT")
    private String token;

    @Column(name = "EXPIRE_DATE")
    private Date expireDate;

}
