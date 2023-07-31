package com.ibrahim.gallery.gallerymanagement.carphoto.mapper;

import com.ibrahim.gallery.gallerymanagement.carphoto.entity.Photo;
import com.ibrahim.gallery.gallerymanagement.common.dto.ItemDTO;
import com.ibrahim.gallery.gallerymanagement.common.mapper.BaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CarPhotoItemDTOMapper extends BaseMapper<Photo, ItemDTO> {

    @Mapping(source = "photoUrl", target = "text")
    @Override
    ItemDTO toDTO(Photo photo);
}
