package com.ttd.paymentservice.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author hp ON 27-10-2023
 * @Description
 **/
@Entity
@Table(name = "Account_details")
@Data
public class Account {
    @Id
    private String accountNo;
    private Double availableBalance;
    private String cardNumber;
    private String cvv;
    private String bank;
}
