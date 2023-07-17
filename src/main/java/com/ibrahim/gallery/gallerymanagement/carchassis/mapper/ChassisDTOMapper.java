package com.ibrahim.gallery.gallerymanagement.carchassis.mapper;

import com.ibrahim.gallery.gallerymanagement.carchassis.dto.ChassisDTO;
import com.ibrahim.gallery.gallerymanagement.carchassis.entity.Chassis;
import com.ibrahim.gallery.gallerymanagement.common.mapper.BaseMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ChassisDTOMapper extends BaseMapper<Chassis, ChassisDTO> {
}
