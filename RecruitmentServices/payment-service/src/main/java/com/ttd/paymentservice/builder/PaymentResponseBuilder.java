package com.ttd.paymentservice.builder;

import com.ttd.paymentservice.dto.PaymentResponse;
import com.ttd.paymentservice.model.Payment;
import org.springframework.stereotype.Component;

/**
 * @author hp ON 27-10-2023
 * @Description
 **/
@Component
public class PaymentResponseBuilder {
    public PaymentResponse buildPaymentResponse(Payment payment) {
        PaymentResponse paymentResponse = new PaymentResponse();
        paymentResponse.setPaymentId(payment.getPaymentId());
        paymentResponse.setName("null as of now");
        paymentResponse.setStatus(payment.getStatus());
        paymentResponse.setAmount(payment.getAmount());
        paymentResponse.setRegistrationId(payment.getRegistrationId());
        return paymentResponse;
    }
}
