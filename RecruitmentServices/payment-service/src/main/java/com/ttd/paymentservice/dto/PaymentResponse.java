package com.ttd.paymentservice.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * @author hp ON 27-10-2023
 * @Description
 **/
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PaymentResponse {
    private String paymentId;
    private String registrationId;
    private Double amount;
    private String status;
    private String name;
}
