package com.ibrahim.gallery.gallerymanagement.carseries.dto;

import com.ibrahim.gallery.gallerymanagement.common.dto.BaseDTO;
import com.ibrahim.gallery.gallerymanagement.common.dto.ItemDTO;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class CarSeriesDTO extends BaseDTO {

    private Long id;

    @NotNull(message = "car.series.not.null.name")
    private String name;

    @NotNull(message = "car.series.not.null.brand")
    private ItemDTO brand;

}
