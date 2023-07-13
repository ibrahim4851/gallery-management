package com.ibrahim.gallery.gallerymanagement.common.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Component
@RestControllerAdvice
public class RequestExceptionHandler {

    private final MessageSource messageSource;
    public static final String ERROR_MESSAGE = "error.message";


    public RequestExceptionHandler(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    ResponseEntity methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException exception) {
        return createApplicationResponse(exception.getFieldErrors(), messageSource);
    }

    @ExceptionHandler(RequestNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    ResponseEntity requestNotValidExceptionHandler(RequestNotValidException requestNotValidException) {

        List<String> errorMessages = requestNotValidException.getErrors().stream()
                .map(error -> getErrorMessage(messageSource, error.getMessage(), error.getArgs()))
                .collect(Collectors.toList());

        return new ResponseEntity(errorMessages, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public ResponseEntity createApplicationResponse(List<FieldError> fieldErrors, MessageSource messageSource) {
        return getErrorMessages(fieldErrors, messageSource);
    }

    private ResponseEntity getErrorMessages(List<FieldError> fieldErrors, MessageSource messageSource) {

        List<String> errorMessages = Optional.ofNullable(fieldErrors)
                .orElse(Collections.emptyList())
                .stream()
                .map(fieldError -> getErrorMessage(messageSource, fieldError.getDefaultMessage(), null))
                .collect(Collectors.toList());

        return new ResponseEntity(errorMessages, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public String getErrorMessage(MessageSource messageSource, String message, Object[] param) {
        try {
            return messageSource.getMessage(message, param, LocaleContextHolder.getLocale());
        } catch (Exception exception) {
            return messageSource.getMessage(ERROR_MESSAGE, null, LocaleContextHolder.getLocale());
        }
    }
}
