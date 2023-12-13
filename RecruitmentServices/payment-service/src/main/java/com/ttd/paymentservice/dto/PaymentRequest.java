package com.ttd.paymentservice.dto;

import lombok.Data;

/**
 * @author hp ON 27-10-2023
 * @Description
 **/
@Data
public class PaymentRequest {
    private String registrationId;
    private String mobile;
    private String cardNumber;
    private String cvv;
    private String post;

}
