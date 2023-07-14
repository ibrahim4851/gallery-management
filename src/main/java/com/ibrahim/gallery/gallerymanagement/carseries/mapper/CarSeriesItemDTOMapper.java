package com.ibrahim.gallery.gallerymanagement.carseries.mapper;

import com.ibrahim.gallery.gallerymanagement.carseries.entity.CarSeries;
import com.ibrahim.gallery.gallerymanagement.common.dto.ItemDTO;
import com.ibrahim.gallery.gallerymanagement.common.mapper.BaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CarSeriesItemDTOMapper extends BaseMapper<CarSeries, ItemDTO> {

    @Mapping(source = "name", target = "text")
    @Override
    ItemDTO toDTO(CarSeries carSeries);
}
