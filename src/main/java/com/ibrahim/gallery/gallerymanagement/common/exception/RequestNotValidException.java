package com.ibrahim.gallery.gallerymanagement.common.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@RequiredArgsConstructor
@Getter
@Setter
public class RequestNotValidException extends RuntimeException {

    private final List<ResponseErrorMessage> errors;

}
