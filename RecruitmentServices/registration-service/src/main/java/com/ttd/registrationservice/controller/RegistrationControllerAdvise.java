package com.ttd.registrationservice.controller;

import com.ttd.registrationservice.dto.RegistrationResponse;
import com.ttd.registrationservice.exception.DuplicateRegistrationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author hp ON 27-10-2023
 * @Description
 **/
@RestControllerAdvice
public class RegistrationControllerAdvise {

    @ExceptionHandler(DuplicateRegistrationException.class)
    public ResponseEntity<RegistrationResponse> handleDuplicateRegistrationException
            (DuplicateRegistrationException exception){
        RegistrationResponse registrationResponse = new RegistrationResponse();
        registrationResponse.setResponseMessage(exception.getErrorMessage());
        return new ResponseEntity<>(registrationResponse, HttpStatus.BAD_REQUEST);
    }

}
