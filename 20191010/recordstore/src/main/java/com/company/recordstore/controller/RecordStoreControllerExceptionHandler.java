package com.company.recordstore.controller;

import com.company.recordstore.exceptions.RecordNotFoundException;
import org.springframework.hateoas.VndErrors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
@RequestMapping(produces = "application/vnd.error+json")
public class RecordStoreControllerExceptionHandler {

    // BELOW - this is the code that runs when we get a MethodArgumentNotValidException
    //         This exception (MethodArgu...) is thrown whenever we validate an object (when there is @Valid present)
    //         and the object fails these validations.
    //         This code very likely would work in any application that uses @Valid for validations. So, use it!
    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public ResponseEntity<VndErrors> handleMethodArgumentNotValidException(MethodArgumentNotValidException e, WebRequest request) {
        // BindingResult in this type of exception holds the validation errors
        BindingResult result = e.getBindingResult();
        // Validation errors are stored in FieldError objects and are available on the binding result from above
        List<FieldError> fieldErrors = result.getFieldErrors();

        // Translate the FieldErrors to VndErrors
        List<VndErrors.VndError> vndErrorList = new ArrayList<>();

        for (FieldError fieldError : fieldErrors) {
            VndErrors.VndError vndError = new VndErrors.VndError(request.toString(), fieldError.getDefaultMessage());
            vndErrorList.add(vndError);
        }

        // Now, put all of those instance of VndError into a VndErrors (plural) object
        VndErrors vndErrors = new VndErrors(vndErrorList);

        //don't forget to return something of the right type!
        ResponseEntity<VndErrors> responseEntity = new ResponseEntity<>(vndErrors, HttpStatus.UNPROCESSABLE_ENTITY);
        return responseEntity;
    }

    @ExceptionHandler(value = {IllegalArgumentException.class})
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public ResponseEntity<VndErrors> handleOutOfRangeException(IllegalArgumentException e, WebRequest request) {
        return buildResponseEntity(e, request, HttpStatus.UNPROCESSABLE_ENTITY);
    }

    private static ResponseEntity<VndErrors> buildResponseEntity(Exception e, WebRequest request, HttpStatus status) {
        VndErrors error = new VndErrors(request.toString(), e.getMessage());
        ResponseEntity<VndErrors> responseEntity = new ResponseEntity<>(error, status);
        return responseEntity;
    }

    @ExceptionHandler(value = {RecordNotFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<VndErrors> handleOutOfRangeException(RecordNotFoundException e, WebRequest request) {
        return buildResponseEntity(e, request, HttpStatus.NOT_FOUND);
    }




}
