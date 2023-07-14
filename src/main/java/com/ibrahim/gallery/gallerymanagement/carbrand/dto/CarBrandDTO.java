package com.ibrahim.gallery.gallerymanagement.carbrand.dto;

import com.ibrahim.gallery.gallerymanagement.common.dto.BaseDTO;
import com.ibrahim.gallery.gallerymanagement.common.dto.ItemDTO;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
public class CarBrandDTO extends BaseDTO {

    private Long id;

    @NotNull(message = "car.brand.not.null.full.name")
    private String fullName;

    private List<ItemDTO> series;

}
