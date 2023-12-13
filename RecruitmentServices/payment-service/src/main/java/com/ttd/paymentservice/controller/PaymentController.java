package com.ttd.paymentservice.controller;

import com.ttd.paymentservice.dto.PaymentRequest;
import com.ttd.paymentservice.dto.PaymentResponse;
import com.ttd.paymentservice.model.Payment;
import com.ttd.paymentservice.service.IPaymentService;
import com.ttd.paymentservice.validator.PaymentRequestValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hp ON 27-10-2023
 * @Description
 **/
@RestController
@RequestMapping("v1/payments")
public class PaymentController {
    @Autowired
    private IPaymentService paymentService;

    @Autowired
    private PaymentRequestValidator paymentRequestValidator;

    @PostMapping("/pay")
    public ResponseEntity<PaymentResponse> payAmount(@RequestBody PaymentRequest paymentRequest){
        paymentRequestValidator.validateRequest(paymentRequest);

        System.out.println(paymentRequest.toString());

        PaymentResponse paymentResponse = paymentService.payAmount(paymentRequest);

        return new ResponseEntity<>(paymentResponse,HttpStatus.OK);
    }
}
