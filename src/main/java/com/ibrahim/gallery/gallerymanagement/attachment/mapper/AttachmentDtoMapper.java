package com.ibrahim.gallery.gallerymanagement.attachment.mapper;

import com.ibrahim.gallery.gallerymanagement.attachment.dto.AttachmentDTO;
import com.ibrahim.gallery.gallerymanagement.attachment.entity.Attachment;
import com.ibrahim.gallery.gallerymanagement.common.mapper.BaseMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AttachmentDtoMapper extends BaseMapper<Attachment, AttachmentDTO> {
}
