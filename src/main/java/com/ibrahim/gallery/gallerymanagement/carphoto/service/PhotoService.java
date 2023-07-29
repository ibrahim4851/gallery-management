package com.ibrahim.gallery.gallerymanagement.carphoto.service;

import com.ibrahim.gallery.gallerymanagement.carphoto.entity.Photo;
import com.ibrahim.gallery.gallerymanagement.carphoto.repository.PhotoRepository;
import com.ibrahim.gallery.gallerymanagement.common.repo.BaseRepository;
import com.ibrahim.gallery.gallerymanagement.common.service.BaseService;
import com.ibrahim.gallery.gallerymanagement.common.service.BaseServiceResult;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PhotoService extends BaseService<Photo, Long> {

    private final PhotoRepository photoRepository;

    @Override
    public BaseRepository<Photo, Long> getRepository() {
        return photoRepository;
    }

    @Override
    public BaseServiceResult<Photo> save(Photo photo) {
        return super.save(photo);
    }
}
