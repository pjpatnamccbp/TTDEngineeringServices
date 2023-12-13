package com.ttd.registrationservice.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author hp ON 27-10-2023
 * @Description
 **/
@Entity
@Table(name = "registration_details")
@Data
public class Registration {
    @Id
    private String registrationId;
    private String post;
    private String name;
    private String aadhaarNumber;
    private String mobile;
    private String email;
    private String gender;
    private String socialStatus;

}
