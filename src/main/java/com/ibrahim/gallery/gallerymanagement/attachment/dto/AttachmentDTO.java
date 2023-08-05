package com.ibrahim.gallery.gallerymanagement.attachment.dto;

import com.ibrahim.gallery.gallerymanagement.car.entity.Car;
import com.ibrahim.gallery.gallerymanagement.carphoto.entity.Photo;
import com.ibrahim.gallery.gallerymanagement.common.dto.BaseDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AttachmentDTO extends BaseDTO {

    private Long id;

    private Car carId;

    private Photo photoId;

}
