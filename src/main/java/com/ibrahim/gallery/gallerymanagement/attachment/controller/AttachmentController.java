package com.ibrahim.gallery.gallerymanagement.attachment.controller;

import com.ibrahim.gallery.gallerymanagement.attachment.dto.AttachmentDTO;
import com.ibrahim.gallery.gallerymanagement.attachment.entity.Attachment;
import com.ibrahim.gallery.gallerymanagement.attachment.mapper.AttachmentDtoMapper;
import com.ibrahim.gallery.gallerymanagement.attachment.service.AttachmentService;
import com.ibrahim.gallery.gallerymanagement.common.controller.BaseController;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/attachments")
public class AttachmentController extends BaseController<Attachment, AttachmentDTO, AttachmentService, AttachmentDtoMapper, Long> {


    private final AttachmentService attachmentService;
    private final AttachmentDtoMapper attachmentDtoMapper;

    public AttachmentController(MessageSource messageSource, AttachmentService attachmentService, AttachmentDtoMapper attachmentDtoMapper) {
        super(messageSource);
        this.attachmentService = attachmentService;
        this.attachmentDtoMapper = attachmentDtoMapper;
    }

    @Override
    protected AttachmentService getService() {
        return attachmentService;
    }

    @Override
    protected AttachmentDtoMapper getMapper() {
        return attachmentDtoMapper;
    }
}
