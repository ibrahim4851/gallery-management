package com.ibrahim.gallery.gallerymanagement.common.service;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class BaseServiceResult<T> {

    private T result;

    private HttpStatus httpStatus = HttpStatus.OK;

    public BaseServiceResult(T result) {
        this.result = result;
    }

    public BaseServiceResult(T result, HttpStatus httpStatus) {
        this.result = result;
        this.httpStatus = httpStatus;
    }

}
