package com.ibrahim.gallery.gallerymanagement.car.dto;

import com.ibrahim.gallery.gallerymanagement.carbrand.dto.CarBrandDTO;
import com.ibrahim.gallery.gallerymanagement.carphoto.dto.PhotoDTO;
import com.ibrahim.gallery.gallerymanagement.common.dto.BaseDTO;
import com.ibrahim.gallery.gallerymanagement.common.dto.ItemDTO;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
public class CarDTO extends BaseDTO {

    private Long id;

    @NotNull(message = "Brand can't be null")
    private CarBrandDTO brand;

    @NotNull(message = "Series Can't be null")
    private ItemDTO carSeries;

    @NotNull(message = "At least one photo should be provided")
    private List<PhotoDTO> photos;

    @NotNull(message = "Model can't be null")
    private String carModel;

    @NotNull(message = "Price can't be null")
    private int price;

    @NotNull(message = "Mileage can't be null")
    private Long mileage;

    @NotNull(message = "Color can't be null")
    private String color;

}
