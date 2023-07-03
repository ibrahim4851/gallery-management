package com.ibrahim.gallery.gallerymanagement.authority.mapper;

import com.ibrahim.gallery.gallerymanagement.authority.dto.AuthorityDTO;
import com.ibrahim.gallery.gallerymanagement.authority.entity.Authority;
import com.ibrahim.gallery.gallerymanagement.common.mapper.BaseMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AuthorityDTOMapper extends BaseMapper<Authority, AuthorityDTO> {
}
