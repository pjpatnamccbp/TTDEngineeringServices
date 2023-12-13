package com.ttd.paymentservice.model;

import lombok.Data;

import javax.persistence.*;

/**
 * @author hp ON 27-10-2023
 * @Description
 **/
@Entity
@Table(name="payment_details")
@Data
public class Payment {

    private String registrationId;
    @Id
    private String paymentId;
    private String mobile;
    private String status;
    private Double amount;
    private String cardNumber;
    private String post;


}
