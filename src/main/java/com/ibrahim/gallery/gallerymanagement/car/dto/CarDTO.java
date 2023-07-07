package com.ibrahim.gallery.gallerymanagement.car.dto;

import com.ibrahim.gallery.gallerymanagement.common.dto.BaseDTO;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class CarDTO extends BaseDTO {

    private Long id;

    @NotNull(message = "brand can't be null")
    private String brand;

    @NotNull(message = "model can't be null")
    private String carModel;

    @NotNull(message = "price can't be null")
    private int price;

    @NotNull(message = "kilometer can't be null")
    private Long kilometers;

    @NotNull(message = "color can't be null")
    private String color;

}
