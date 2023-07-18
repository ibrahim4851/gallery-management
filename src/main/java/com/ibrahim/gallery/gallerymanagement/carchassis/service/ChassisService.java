package com.ibrahim.gallery.gallerymanagement.carchassis.service;

import com.ibrahim.gallery.gallerymanagement.carchassis.entity.Chassis;
import com.ibrahim.gallery.gallerymanagement.carchassis.repository.ChassisRepository;
import com.ibrahim.gallery.gallerymanagement.common.repo.BaseRepository;
import com.ibrahim.gallery.gallerymanagement.common.service.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChassisService extends BaseService<Chassis, Long> {

    private final ChassisRepository chassisRepository;

    @Override
    public BaseRepository<Chassis, Long> getRepository() {
        return chassisRepository;
    }
}
