package com.ibrahim.gallery.gallerymanagement.carphoto.dto;

import com.ibrahim.gallery.gallerymanagement.common.dto.BaseDTO;
import com.ibrahim.gallery.gallerymanagement.common.dto.ItemDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PhotoDTO extends BaseDTO {

    private Long id;

    private ItemDTO car;

    private String url;

}
