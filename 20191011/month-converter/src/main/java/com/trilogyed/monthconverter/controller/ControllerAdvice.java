package com.trilogyed.monthconverter.controller;

import com.trilogyed.monthconverter.exception.InputOutOfRangeException;
import org.springframework.hateoas.VndErrors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
@RequestMapping(produces = "application/vnd.error+json")
public class ControllerAdvice {
    @ExceptionHandler(value = {InputOutOfRangeException.class})
    @ResponseStatus(HttpStatus.I_AM_A_TEAPOT)
    public ResponseEntity<VndErrors> handleOutOfRangeException(InputOutOfRangeException e, WebRequest request) {
        return buildResponseEntity(e, request, HttpStatus.I_AM_A_TEAPOT);
    }

    private static ResponseEntity<VndErrors> buildResponseEntity(Exception e, WebRequest request, HttpStatus status) {
        VndErrors error = new VndErrors(request.toString(), e.getMessage());
        ResponseEntity<VndErrors> responseEntity = new ResponseEntity<>(error, status);
        return responseEntity;
    }

}
