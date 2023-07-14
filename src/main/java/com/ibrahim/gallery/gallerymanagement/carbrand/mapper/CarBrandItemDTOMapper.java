package com.ibrahim.gallery.gallerymanagement.carbrand.mapper;

import com.ibrahim.gallery.gallerymanagement.carbrand.entity.CarBrand;
import com.ibrahim.gallery.gallerymanagement.common.dto.ItemDTO;
import com.ibrahim.gallery.gallerymanagement.common.mapper.BaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CarBrandItemDTOMapper extends BaseMapper<CarBrand, ItemDTO> {

    @Mapping(source = "fullName", target = "text")
    @Override
    ItemDTO toDTO(CarBrand carBrand);
}
