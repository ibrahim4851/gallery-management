package com.ibrahim.gallery.gallerymanagement.carbrand.controller;

import com.ibrahim.gallery.gallerymanagement.carbrand.dto.CarBrandDTO;
import com.ibrahim.gallery.gallerymanagement.carbrand.entity.CarBrand;
import com.ibrahim.gallery.gallerymanagement.carbrand.mapper.CarBrandDTOMapper;
import com.ibrahim.gallery.gallerymanagement.carbrand.service.CarBrandService;
import com.ibrahim.gallery.gallerymanagement.common.controller.BaseController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("brands")
public class CarBrandController extends BaseController<CarBrand, CarBrandDTO, CarBrandService, CarBrandDTOMapper, Long> {

    private final CarBrandService carBrandService;
    private final CarBrandDTOMapper carBrandDTOMapper;

    public CarBrandController(CarBrandService carBrandService, CarBrandDTOMapper carBrandDTOMapper) {
        this.carBrandService = carBrandService;
        this.carBrandDTOMapper = carBrandDTOMapper;
    }

    @Override
    protected CarBrandService getService() {
        return carBrandService;
    }

    @Override
    protected CarBrandDTOMapper getMapper() {
        return carBrandDTOMapper;
    }
}
