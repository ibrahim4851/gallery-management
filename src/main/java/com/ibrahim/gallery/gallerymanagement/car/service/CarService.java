package com.ibrahim.gallery.gallerymanagement.car.service;

import com.ibrahim.gallery.gallerymanagement.car.entity.Car;
import com.ibrahim.gallery.gallerymanagement.car.repository.CarRepository;
import com.ibrahim.gallery.gallerymanagement.common.repo.BaseRepository;
import com.ibrahim.gallery.gallerymanagement.common.service.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CarService extends BaseService<Car, Long> {

    private final CarRepository carRepository;
    @Override
    public BaseRepository<Car, Long> getRepository() {
        return carRepository;
    }
}
