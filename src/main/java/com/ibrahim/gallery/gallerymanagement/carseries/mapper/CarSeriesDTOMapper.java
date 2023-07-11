package com.ibrahim.gallery.gallerymanagement.carseries.mapper;

import com.ibrahim.gallery.gallerymanagement.carseries.dto.CarSeriesDTO;
import com.ibrahim.gallery.gallerymanagement.carseries.entity.CarSeries;
import com.ibrahim.gallery.gallerymanagement.common.mapper.BaseMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CarSeriesDTOMapper extends BaseMapper<CarSeries, CarSeriesDTO> {
}
