package com.ibrahim.gallery.gallerymanagement.carchassis.entity;

import com.ibrahim.gallery.gallerymanagement.common.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serial;

@Getter
@Setter
@Table(name = "CHASSIS")
@Entity
public class Chassis extends BaseEntity {

    @Serial
    private static final long serialVersionUID = 8719256499823411325L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;

}
