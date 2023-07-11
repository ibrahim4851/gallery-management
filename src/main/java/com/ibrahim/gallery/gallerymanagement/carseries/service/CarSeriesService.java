package com.ibrahim.gallery.gallerymanagement.carseries.service;

import com.ibrahim.gallery.gallerymanagement.carseries.entity.CarSeries;
import com.ibrahim.gallery.gallerymanagement.carseries.repository.CarSeriesRepository;
import com.ibrahim.gallery.gallerymanagement.common.repo.BaseRepository;
import com.ibrahim.gallery.gallerymanagement.common.service.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CarSeriesService extends BaseService<CarSeries, Long> {

    private final CarSeriesRepository carSeriesRepository;


    @Override
    public BaseRepository<CarSeries, Long> getRepository() {
        return carSeriesRepository;
    }
}
