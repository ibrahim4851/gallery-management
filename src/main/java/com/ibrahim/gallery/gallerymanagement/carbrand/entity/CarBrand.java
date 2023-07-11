package com.ibrahim.gallery.gallerymanagement.carbrand.entity;

import com.ibrahim.gallery.gallerymanagement.carseries.entity.CarSeries;
import com.ibrahim.gallery.gallerymanagement.common.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serial;
import java.util.List;

@Getter
@Setter
@Table(name = "BRANDS")
@Entity
public class CarBrand extends BaseEntity {

    @Serial
    private static final long serialVersionUID = 7148152353130606381L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    private String fullName;

    @OneToMany(mappedBy = "brand")
    List<CarSeries> series;

}
