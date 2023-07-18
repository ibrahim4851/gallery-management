package com.ibrahim.gallery.gallerymanagement.carchassis.controller;

import com.ibrahim.gallery.gallerymanagement.carchassis.dto.ChassisDTO;
import com.ibrahim.gallery.gallerymanagement.carchassis.entity.Chassis;
import com.ibrahim.gallery.gallerymanagement.carchassis.mapper.ChassisDTOMapper;
import com.ibrahim.gallery.gallerymanagement.carchassis.service.ChassisService;
import com.ibrahim.gallery.gallerymanagement.common.controller.BaseController;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("chassis")
public class ChassisController extends BaseController<Chassis, ChassisDTO, ChassisService, ChassisDTOMapper, Long> {

    private final ChassisService chassisService;

    private final ChassisDTOMapper chassisDTOMapper;

    public ChassisController(MessageSource messageSource, ChassisService chassisService, ChassisDTOMapper chassisDTOMapper) {
        super(messageSource);
        this.chassisService = chassisService;
        this.chassisDTOMapper = chassisDTOMapper;
    }


    @Override
    protected ChassisService getService() {
        return chassisService;
    }

    @Override
    protected ChassisDTOMapper getMapper() {
        return chassisDTOMapper;
    }
}
