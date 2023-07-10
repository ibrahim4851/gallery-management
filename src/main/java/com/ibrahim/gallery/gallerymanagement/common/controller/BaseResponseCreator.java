package com.ibrahim.gallery.gallerymanagement.common.controller;

import com.ibrahim.gallery.gallerymanagement.common.service.BaseServiceResult;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public abstract class BaseResponseCreator<DTO> {

    protected ResponseEntity createResponse(BaseServiceResult serviceResult) {
        return new ResponseEntity<>(serviceResult.getResult(), serviceResult.getHttpStatus());
    }

    protected ResponseEntity createResponse(DTO dto) {
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    protected ResponseEntity createResponse(List<DTO> dtos) {
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

}
