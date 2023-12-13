package com.ttd.registrationservice.service;

import com.ttd.registrationservice.builder.RegistrationRequestBuilder;
import com.ttd.registrationservice.builder.RegistrationResponseBuilder;
import com.ttd.registrationservice.dao.IRegistrationRepository;
import com.ttd.registrationservice.dto.RegistrationRequest;
import com.ttd.registrationservice.dto.RegistrationResponse;
import com.ttd.registrationservice.exception.DuplicateRegistrationException;
import com.ttd.registrationservice.model.Registration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;
import java.util.Random;

/**
 * @author hp ON 27-10-2023
 * @Description
 **/
@Service
public class RegistrationServiceImpl implements IRegistrationService{
    @Autowired
    private IRegistrationRepository registrationRepository;
    @Autowired
    private RegistrationRequestBuilder registrationRequestBuilder;
    @Autowired
    private RegistrationResponseBuilder registrationResponseBuilder;
    @Override
    public RegistrationResponse register(RegistrationRequest registrationRequest) {

        Optional<Registration> optionalRegistration =
                registrationRepository.findByEmailAndMobile(registrationRequest.getEmail(),registrationRequest.getMobile());

        if(optionalRegistration.isPresent()){
            throw new DuplicateRegistrationException(String.format("Registration already done for email %s and mobile %s",
                    registrationRequest.getEmail(),registrationRequest.getMobile()));
        }

        String registrationId = generateRegistrationId();
        Registration savedRegistration = registrationRepository.save(
                registrationRequestBuilder.buildRegistration(registrationRequest,registrationId));


        return registrationResponseBuilder.buildRegistrationResponse(savedRegistration);
    }

    private String generateRegistrationId() {

        Random random = new Random();
        int rand = random.nextInt(9000)+1000;
        Date date = new Date();

        String registrationId = ""+date.getYear()+"00"+rand;
        return registrationId;
    }
}
