package com.ttd.paymentservice.dto;

import lombok.Data;

/**
 * @author hp ON 27-10-2023
 * @Description
 **/
@Data
public class AccountResponse {
    private String responseMessage;
    private Double availableBalance;
    private String status;
}
