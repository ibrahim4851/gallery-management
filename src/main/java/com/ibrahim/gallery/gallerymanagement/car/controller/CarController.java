package com.ibrahim.gallery.gallerymanagement.car.controller;

import com.ibrahim.gallery.gallerymanagement.car.mapper.CarDtoMapper;
import com.ibrahim.gallery.gallerymanagement.car.service.CarService;
import com.ibrahim.gallery.gallerymanagement.common.BaseController;
import com.ibrahim.gallery.gallerymanagement.common.mapper.BaseMapper;
import com.ibrahim.gallery.gallerymanagement.common.service.BaseService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("cars")
public class CarController extends BaseController {

    private final CarService carService;
    private final CarDtoMapper carDtoMapper;

    public CarController(CarService carService, CarDtoMapper carDtoMapper) {
        this.carService = carService;
        this.carDtoMapper = carDtoMapper;
    }

    @Override
    protected BaseService getService() {
        return carService;
    }

    @Override
    protected BaseMapper getMapper() {
        return carDtoMapper;
    }
}
