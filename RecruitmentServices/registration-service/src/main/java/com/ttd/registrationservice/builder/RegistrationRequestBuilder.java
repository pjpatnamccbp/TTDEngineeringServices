package com.ttd.registrationservice.builder;

import com.ttd.registrationservice.dto.RegistrationRequest;
import com.ttd.registrationservice.model.Registration;
import org.springframework.stereotype.Component;

/**
 * @author hp ON 27-10-2023
 * @Description
 **/
@Component
public class RegistrationRequestBuilder {
    public Registration buildRegistration(RegistrationRequest registrationRequest, String registrationId) {
        Registration registration = new Registration();

        registration.setPost(registrationRequest.getPost());
        registration.setRegistrationId(registrationId);
        registration.setEmail(registrationRequest.getEmail());
        registration.setName(registrationRequest.getName());
        registration.setMobile(registrationRequest.getMobile());
        registration.setAadhaarNumber(registrationRequest.getAadhaarNumber());
        registration.setGender(registrationRequest.getGender());
        registration.setSocialStatus(registrationRequest.getSocialStatus());

        return registration;
    }
}
