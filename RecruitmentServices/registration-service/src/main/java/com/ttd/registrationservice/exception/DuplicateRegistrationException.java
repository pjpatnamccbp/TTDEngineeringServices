package com.ttd.registrationservice.exception;

import lombok.Getter;

/**
 * @author hp ON 27-10-2023
 * @Description
 **/
@Getter
public class DuplicateRegistrationException extends RuntimeException{
    private String errorMessage;
    public DuplicateRegistrationException(String errorMessage){
        this.errorMessage = errorMessage;
    }
}
