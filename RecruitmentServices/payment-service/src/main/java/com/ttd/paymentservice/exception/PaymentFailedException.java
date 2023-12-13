package com.ttd.paymentservice.exception;

import lombok.Getter;

/**
 * @author hp ON 27-10-2023
 * @Description
 **/
@Getter
public class PaymentFailedException extends RuntimeException{
    private String errorMessage;
    public PaymentFailedException(String errorMessage){
        this.errorMessage = errorMessage;
    }
}
