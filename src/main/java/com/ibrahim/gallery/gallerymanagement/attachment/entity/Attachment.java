package com.ibrahim.gallery.gallerymanagement.attachment.entity;

import com.ibrahim.gallery.gallerymanagement.car.entity.Car;
import com.ibrahim.gallery.gallerymanagement.carphoto.entity.Photo;
import com.ibrahim.gallery.gallerymanagement.common.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serial;

@Entity
@Table(name = "ATTACHMENTS")
@Getter
@Setter
public class Attachment extends BaseEntity {

    @Serial
    private static final long serialVersionUID = -2300919685389642562L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    private Car carId;

    @OneToOne
    private Photo photoId;

}
