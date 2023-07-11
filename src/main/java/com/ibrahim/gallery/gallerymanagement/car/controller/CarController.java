package com.ibrahim.gallery.gallerymanagement.car.controller;

import com.ibrahim.gallery.gallerymanagement.car.dto.CarDTO;
import com.ibrahim.gallery.gallerymanagement.car.entity.Car;
import com.ibrahim.gallery.gallerymanagement.car.mapper.CarDtoMapper;
import com.ibrahim.gallery.gallerymanagement.car.service.CarService;
import com.ibrahim.gallery.gallerymanagement.common.controller.BaseController;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("cars")
public class CarController extends BaseController<Car, CarDTO, CarService, CarDtoMapper, Long> {

    private final CarService carService;
    private final CarDtoMapper carDtoMapper;

    public CarController(CarService carService, CarDtoMapper carDtoMapper) {
        this.carService = carService;
        this.carDtoMapper = carDtoMapper;
    }

    @Override
    protected CarService getService() {
        return carService;
    }

    @Override
    protected CarDtoMapper getMapper() {
        return carDtoMapper;
    }

    @Override
    @PreAuthorize("hasAuthority('app:create')")
    public ResponseEntity save(CarDTO dto) {
        return super.save(dto);
    }
}
