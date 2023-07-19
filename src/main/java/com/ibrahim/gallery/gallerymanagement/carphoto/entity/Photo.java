package com.ibrahim.gallery.gallerymanagement.carphoto.entity;

import com.ibrahim.gallery.gallerymanagement.car.entity.Car;
import com.ibrahim.gallery.gallerymanagement.common.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serial;

@Getter
@Setter
@Table(name = "PHOTOS")
@Entity
public class Photo extends BaseEntity {

    @Serial
    private static final long serialVersionUID = 5740300648990246735L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "car_id", nullable = false)
    private Car car;

    private String photoUrl;

}
