package com.ibrahim.gallery.gallerymanagement.user.mapper;

import com.ibrahim.gallery.gallerymanagement.common.mapper.BaseMapper;
import com.ibrahim.gallery.gallerymanagement.user.dto.UserDTO;
import com.ibrahim.gallery.gallerymanagement.user.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserDTOMapper extends BaseMapper<User, UserDTO> {
}
