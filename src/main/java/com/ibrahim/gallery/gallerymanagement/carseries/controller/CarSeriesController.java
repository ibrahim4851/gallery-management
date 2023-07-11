package com.ibrahim.gallery.gallerymanagement.carseries.controller;

import com.ibrahim.gallery.gallerymanagement.carseries.dto.CarSeriesDTO;
import com.ibrahim.gallery.gallerymanagement.carseries.entity.CarSeries;
import com.ibrahim.gallery.gallerymanagement.carseries.mapper.CarSeriesDTOMapper;
import com.ibrahim.gallery.gallerymanagement.carseries.service.CarSeriesService;
import com.ibrahim.gallery.gallerymanagement.common.controller.BaseController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("series")
public class CarSeriesController extends BaseController<CarSeries, CarSeriesDTO, CarSeriesService, CarSeriesDTOMapper, Long> {

    private final CarSeriesService carSeriesService;
    private final CarSeriesDTOMapper carSeriesDTOMapper;

    public CarSeriesController(CarSeriesService carSeriesService, CarSeriesDTOMapper carSeriesDTOMapper) {
        this.carSeriesService = carSeriesService;
        this.carSeriesDTOMapper = carSeriesDTOMapper;
    }

    @Override
    protected CarSeriesService getService() {
        return carSeriesService;
    }

    @Override
    protected CarSeriesDTOMapper getMapper() {
        return carSeriesDTOMapper;
    }
}
