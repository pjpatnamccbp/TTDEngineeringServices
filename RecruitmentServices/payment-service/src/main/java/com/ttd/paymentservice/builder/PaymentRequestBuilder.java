package com.ttd.paymentservice.builder;

import com.ttd.paymentservice.dto.PaymentRequest;
import com.ttd.paymentservice.model.Payment;
import org.springframework.stereotype.Component;

/**
 * @author hp ON 27-10-2023
 * @Description
 **/
@Component
public class PaymentRequestBuilder {
    public Payment buildPaymentDetails(String paymentId, PaymentRequest paymentRequest) {
        Payment payment = new Payment();
        payment.setPaymentId(paymentId);
        payment.setPost(paymentRequest.getPost());
        payment.setMobile(paymentRequest.getMobile());
        payment.setAmount(paymentRequest.getPost().equalsIgnoreCase("AEE")?280.0:250.0);
        payment.setStatus("Paid");
        payment.setCardNumber(paymentRequest.getCardNumber());
        payment.setRegistrationId(paymentRequest.getRegistrationId());
        return payment;
    }
}
