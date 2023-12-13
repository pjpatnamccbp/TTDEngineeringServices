package com.ttd.paymentservice.service;

import com.ttd.paymentservice.dto.PaymentRequest;
import com.ttd.paymentservice.dto.PaymentResponse;

/**
 * @author hp ON 27-10-2023
 * @Description
 **/
public interface IPaymentService {
    PaymentResponse payAmount(PaymentRequest paymentRequest);
}
