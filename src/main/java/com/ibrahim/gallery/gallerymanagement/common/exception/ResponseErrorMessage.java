package com.ibrahim.gallery.gallerymanagement.common.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ResponseErrorMessage {

    private String message;

    private Object[] args;

}
