package com.ttd.registrationservice.controller;

import com.ttd.registrationservice.dto.RegistrationRequest;
import com.ttd.registrationservice.dto.RegistrationResponse;
import com.ttd.registrationservice.model.Registration;
import com.ttd.registrationservice.service.IRegistrationService;
import com.ttd.registrationservice.validator.RegistrationValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hp ON 27-10-2023
 * @Description
 **/
@RestController
@RequestMapping("/v1/registration")
public class RegistrationController {
    @Autowired
    private IRegistrationService registrationService;
    @Autowired
    private RegistrationValidator registrationValidator;


    @PostMapping("/register")
    public ResponseEntity<RegistrationResponse> register(@RequestBody RegistrationRequest registrationRequest){
        registrationValidator.validateRequest(registrationRequest);
        RegistrationResponse registrationResponse =registrationService.register(registrationRequest);

        return new ResponseEntity<>(registrationResponse, HttpStatus.CREATED);
    }
}
