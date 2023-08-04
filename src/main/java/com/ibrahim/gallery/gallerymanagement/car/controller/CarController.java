package com.ibrahim.gallery.gallerymanagement.car.controller;

import com.ibrahim.gallery.gallerymanagement.car.dto.CarDTO;
import com.ibrahim.gallery.gallerymanagement.car.entity.Car;
import com.ibrahim.gallery.gallerymanagement.car.mapper.CarDtoMapper;
import com.ibrahim.gallery.gallerymanagement.car.service.CarService;
import com.ibrahim.gallery.gallerymanagement.common.controller.BaseController;
import org.springframework.context.MessageSource;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("cars")
public class CarController extends BaseController<Car, CarDTO, CarService, CarDtoMapper, Long> {

    private final CarService carService;
    private final CarDtoMapper carDtoMapper;

    public CarController(MessageSource messageSource, CarService carService, CarDtoMapper carDtoMapper) {
        super(messageSource);
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

    @PreAuthorize("hasAuthority('app:create')")
    @PostMapping("/save")
    public ResponseEntity save(@RequestPart CarDTO dto, @RequestPart List<MultipartFile> carPhotos) {
        return super.save(dto);
    }


}
