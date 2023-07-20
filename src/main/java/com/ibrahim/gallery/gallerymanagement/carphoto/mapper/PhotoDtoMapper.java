package com.ibrahim.gallery.gallerymanagement.carphoto.mapper;

import com.ibrahim.gallery.gallerymanagement.carphoto.dto.PhotoDTO;
import com.ibrahim.gallery.gallerymanagement.carphoto.entity.Photo;
import com.ibrahim.gallery.gallerymanagement.common.mapper.BaseMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PhotoDtoMapper extends BaseMapper<Photo, PhotoDTO> {
}
