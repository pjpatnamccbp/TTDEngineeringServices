package com.ttd.paymentservice.dto;

import lombok.Data;

/**
 * @author hp ON 27-10-2023
 * @Description
 **/
@Data
public class AccountRequest {
    private String accountNo;
    private Double availableBalance;
    private String cardNumber;
    private String cvv;
}
