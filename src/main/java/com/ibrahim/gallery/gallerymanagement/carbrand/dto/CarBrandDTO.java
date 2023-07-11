package com.ibrahim.gallery.gallerymanagement.carbrand.dto;

import com.ibrahim.gallery.gallerymanagement.common.dto.BaseDTO;
import com.ibrahim.gallery.gallerymanagement.common.dto.ItemDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CarBrandDTO extends BaseDTO {

    private Long id;

    private String fullName;

    private List<ItemDTO> series;

}
