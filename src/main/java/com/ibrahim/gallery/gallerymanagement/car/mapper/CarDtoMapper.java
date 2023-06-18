package com.ibrahim.gallery.gallerymanagement.car.mapper;

import com.ibrahim.gallery.gallerymanagement.car.dto.CarDTO;
import com.ibrahim.gallery.gallerymanagement.car.entity.Car;
import com.ibrahim.gallery.gallerymanagement.common.mapper.BaseMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CarDtoMapper extends BaseMapper<Car, CarDTO> {
}
