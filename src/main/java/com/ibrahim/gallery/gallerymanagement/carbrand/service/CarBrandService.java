package com.ibrahim.gallery.gallerymanagement.carbrand.service;

import com.ibrahim.gallery.gallerymanagement.carbrand.entity.CarBrand;
import com.ibrahim.gallery.gallerymanagement.carbrand.repository.CarBrandRepository;
import com.ibrahim.gallery.gallerymanagement.common.repo.BaseRepository;
import com.ibrahim.gallery.gallerymanagement.common.service.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CarBrandService extends BaseService<CarBrand, Long> {

    private final CarBrandRepository carBrandRepository;

    @Override
    public BaseRepository<CarBrand, Long> getRepository() {
        return carBrandRepository;
    }
}
