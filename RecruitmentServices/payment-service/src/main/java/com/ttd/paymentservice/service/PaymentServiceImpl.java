package com.ttd.paymentservice.service;

import com.ttd.paymentservice.builder.PaymentRequestBuilder;
import com.ttd.paymentservice.builder.PaymentResponseBuilder;
import com.ttd.paymentservice.dao.IPaymentRepository;
import com.ttd.paymentservice.dto.*;
import com.ttd.paymentservice.exception.PaymentFailedException;
import com.ttd.paymentservice.model.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.servlet.Registration;
import java.util.Random;

/**
 * @author hp ON 27-10-2023
 * @Description
 **/
@Service
public class PaymentServiceImpl implements IPaymentService{

    @Autowired
    RestTemplate restTemplate;
    @Autowired
    private IPaymentRepository paymentRepository;
    @Autowired
    private PaymentResponseBuilder paymentResponseBuilder;

    @Autowired
    private PaymentRequestBuilder paymentRequestBuilder;

    @Override
    public PaymentResponse payAmount(PaymentRequest paymentRequest) {
        String paymentId = checkCardAndPay(paymentRequest);
        System.out.println("payment done  "+paymentId);
        Payment payment = paymentRepository.save(paymentRequestBuilder.buildPaymentDetails(paymentId,paymentRequest));
        //RegistrationResponse registrationResponse= getRegistrationDetails(paymentRequest.getRegistrationId());

        return paymentResponseBuilder.buildPaymentResponse(payment);
    }

    private String checkCardAndPay(PaymentRequest paymentRequest) {
        String paymentId = "";
        String paymentUrl = "http://localhost:8081/v1/account/transfer";

        TransferRequest transferRequest = new TransferRequest();
        transferRequest.setCardNumber(paymentRequest.getCardNumber());
        transferRequest.setCvv(paymentRequest.getCvv());
        Double amount = paymentRequest.getPost().equalsIgnoreCase("AEE")?280.0:250.0;
        transferRequest.setAmount(amount);

        TransferResponse transferResponse = restTemplate.postForObject(paymentUrl,transferRequest,TransferResponse.class);

        if(transferResponse.getResponseCode().equals("0")){
            System.out.println(transferResponse.toString());
            paymentId = generatePaymentId(paymentRequest.getRegistrationId());
        }else{
            throw new PaymentFailedException(transferResponse.getResponseMessage());
        }
        return paymentId;
    }

    private String generatePaymentId(String registrationId) {
        Random random = new Random();
        int randInt = random.nextInt(900)+100;
        return registrationId+randInt;
    }
}
