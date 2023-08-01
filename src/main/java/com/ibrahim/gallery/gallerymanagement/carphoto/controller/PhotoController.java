package com.ibrahim.gallery.gallerymanagement.carphoto.controller;

import com.ibrahim.gallery.gallerymanagement.carphoto.dto.PhotoDTO;
import com.ibrahim.gallery.gallerymanagement.carphoto.entity.Photo;
import com.ibrahim.gallery.gallerymanagement.carphoto.mapper.PhotoDtoMapper;
import com.ibrahim.gallery.gallerymanagement.carphoto.service.PhotoService;
import com.ibrahim.gallery.gallerymanagement.common.controller.BaseController;
import org.springframework.context.MessageSource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("photos")
public class PhotoController extends BaseController<Photo, PhotoDTO, PhotoService, PhotoDtoMapper, Long> {

    private final PhotoService photoService;

    private final  PhotoDtoMapper photoDtoMapper;

    public PhotoController(MessageSource messageSource, PhotoService photoService, PhotoDtoMapper photoDtoMapper) {
        super(messageSource);
        this.photoService = photoService;
        this.photoDtoMapper = photoDtoMapper;
    }


    @Override
    protected PhotoService getService() {
        return photoService;
    }

    @Override
    protected PhotoDtoMapper getMapper() {
        return photoDtoMapper;
    }

    @Override
    public ResponseEntity save(PhotoDTO dto) {
        return super.save(dto);
    }

}
