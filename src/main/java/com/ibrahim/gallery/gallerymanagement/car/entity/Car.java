package com.ibrahim.gallery.gallerymanagement.car.entity;

import com.ibrahim.gallery.gallerymanagement.common.entity.BaseEntity;
import com.ibrahim.gallery.gallerymanagement.user.entity.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serial;

@Getter
@Setter
@Table(name = "CARS")
@Entity
public class Car extends BaseEntity {

    @Serial
    private static final long serialVersionUID = 1323094364761554963L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    private String brand;

    private String carModel;

    private int price;

    private Long kilometers;

    private String color;

    @ManyToOne
    private User user;

}
