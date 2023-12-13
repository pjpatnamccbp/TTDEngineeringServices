package com.ttd.paymentservice.exception;

import lombok.Getter;

/**
 * @author hp ON 27-10-2023
 * @Description
 **/
@Getter
public class InsufficientBalanceException extends RuntimeException{
    private String errorMessage;
    public InsufficientBalanceException(String errorMessage){
        this.errorMessage = errorMessage;
    }
}
