package com.ttd.paymentservice.controller;

import com.ttd.paymentservice.dto.PaymentResponse;
import com.ttd.paymentservice.dto.TransferResponse;
import com.ttd.paymentservice.exception.CardNotValidException;
import com.ttd.paymentservice.exception.InsufficientBalanceException;
import com.ttd.paymentservice.exception.PaymentFailedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author hp ON 27-10-2023
 * @Description
 **/
@RestControllerAdvice
public class GlobalControllerAdvice {
    @ExceptionHandler(CardNotValidException.class)
    public TransferResponse handleCardNotValidException(CardNotValidException exception){
        TransferResponse transferResponse = new TransferResponse();
        transferResponse.setResponseCode("1");
        transferResponse.setResponseMessage(exception.getErrorMessage());
        return transferResponse;
    }
    @ExceptionHandler(InsufficientBalanceException.class)
     public TransferResponse handleInsufficientBalanceException(InsufficientBalanceException exception){
         TransferResponse transferResponse = new TransferResponse();
         transferResponse.setResponseCode("1");
         transferResponse.setResponseMessage(exception.getErrorMessage());
         return transferResponse;
     }
     @ExceptionHandler(PaymentFailedException.class)
     public PaymentResponse handlePaymentFailedException(PaymentFailedException exception){
        PaymentResponse paymentResponse = new PaymentResponse();
        paymentResponse.setStatus(exception.getErrorMessage());
        return paymentResponse;
     }

}
