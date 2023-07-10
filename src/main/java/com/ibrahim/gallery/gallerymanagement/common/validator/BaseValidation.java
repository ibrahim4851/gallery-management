package com.ibrahim.gallery.gallerymanagement.common.validator;

import com.ibrahim.gallery.gallerymanagement.common.entity.ResponseErrorMessage;

import java.util.List;

public interface BaseValidation<T> {

    List<ResponseErrorMessage> validate(T entity);

}
