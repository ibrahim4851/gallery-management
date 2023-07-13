package com.ibrahim.gallery.gallerymanagement.common.validator;

import com.ibrahim.gallery.gallerymanagement.common.exception.ResponseErrorMessage;

import java.util.List;

public interface BaseValidation<T> {

    List<ResponseErrorMessage> validate(T entity);

}
