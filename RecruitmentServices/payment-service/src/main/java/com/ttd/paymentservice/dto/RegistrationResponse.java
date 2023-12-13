package com.ttd.paymentservice.dto;

import lombok.Data;

/**
 * @author hp ON 27-10-2023
 * @Description
 **/
@Data
public class RegistrationResponse {
    private String responseCode;
    private String responseMessage;
    private String registrationId;
}
