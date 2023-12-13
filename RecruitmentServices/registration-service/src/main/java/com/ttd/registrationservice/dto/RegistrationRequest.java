package com.ttd.registrationservice.dto;

import lombok.Data;

/**
 * @author hp ON 27-10-2023
 * @Description
 **/
@Data
public class RegistrationRequest {
    private String post;
    private String name;
    private String aadhaarNumber;
    private String mobile;
    private String email;
    private String gender;
    private String socialStatus;
}
