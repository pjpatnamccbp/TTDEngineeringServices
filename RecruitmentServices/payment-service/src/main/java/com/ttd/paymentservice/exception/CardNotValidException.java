package com.ttd.paymentservice.exception;

import lombok.Getter;

/**
 * @author hp ON 27-10-2023
 * @Description
 **/
@Getter
public class CardNotValidException extends RuntimeException{
    private String errorMessage;
    public CardNotValidException(String errorMessage){
        this.errorMessage = errorMessage;
    }
}
