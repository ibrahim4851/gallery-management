package com.ibrahim.gallery.gallerymanagement.carseries.dto;

import com.ibrahim.gallery.gallerymanagement.common.dto.BaseDTO;
import com.ibrahim.gallery.gallerymanagement.common.dto.ItemDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CarSeriesDTO extends BaseDTO {

    private Long id;

    private String name;

    private ItemDTO brand;

}
