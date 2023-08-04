package com.ibrahim.gallery.gallerymanagement.attachment.service;

import com.ibrahim.gallery.gallerymanagement.attachment.entity.Attachment;
import com.ibrahim.gallery.gallerymanagement.attachment.repository.AttachmentRepository;
import com.ibrahim.gallery.gallerymanagement.common.repo.BaseRepository;
import com.ibrahim.gallery.gallerymanagement.common.service.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AttachmentService extends BaseService<Attachment, Long> {

    private final AttachmentRepository attachmentRepository;

    @Override
    public BaseRepository<Attachment, Long> getRepository() {
        return attachmentRepository;
    }
}
