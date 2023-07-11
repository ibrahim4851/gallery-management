package com.ibrahim.gallery.gallerymanagement.carbrand.mapper;

import com.ibrahim.gallery.gallerymanagement.carbrand.dto.CarBrandDTO;
import com.ibrahim.gallery.gallerymanagement.carbrand.entity.CarBrand;
import com.ibrahim.gallery.gallerymanagement.common.mapper.BaseMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CarBrandDTOMapper extends BaseMapper<CarBrand, CarBrandDTO> {
}
