package com.ttd.registrationservice.builder;

import com.ttd.registrationservice.dto.RegistrationResponse;
import com.ttd.registrationservice.model.Registration;
import org.springframework.stereotype.Component;

import javax.persistence.Column;

/**
 * @author hp ON 27-10-2023
 * @Description
 **/
@Component
public class RegistrationResponseBuilder {
    public RegistrationResponse buildRegistrationResponse(Registration savedRegistration) {
        RegistrationResponse registrationResponse = new RegistrationResponse();
        registrationResponse.setResponseCode("0");
        registrationResponse.setResponseMessage("success");
        registrationResponse.setRegistrationId(savedRegistration.getRegistrationId());
        return registrationResponse;
    }
}
