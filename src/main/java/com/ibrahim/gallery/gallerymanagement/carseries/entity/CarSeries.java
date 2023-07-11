package com.ibrahim.gallery.gallerymanagement.carseries.entity;

import com.ibrahim.gallery.gallerymanagement.car.entity.Car;
import com.ibrahim.gallery.gallerymanagement.carbrand.entity.CarBrand;
import com.ibrahim.gallery.gallerymanagement.common.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serial;
import java.util.List;

@Getter
@Setter
@Table(name = "SERIES")
@Entity
public class CarSeries extends BaseEntity {

    @Serial
    private static final long serialVersionUID = -463137082778584023L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "brand_id")
    private CarBrand brand;

    @OneToMany(mappedBy = "carSeries")
    private List<Car> cars;
}
