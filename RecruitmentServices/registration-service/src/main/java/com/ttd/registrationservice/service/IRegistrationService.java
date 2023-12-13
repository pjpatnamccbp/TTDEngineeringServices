package com.ttd.registrationservice.service;

import com.ttd.registrationservice.dto.RegistrationRequest;
import com.ttd.registrationservice.dto.RegistrationResponse;

/**
 * @author hp ON 27-10-2023
 * @Description
 **/
public interface IRegistrationService {
    RegistrationResponse register(RegistrationRequest registrationRequest);
}
