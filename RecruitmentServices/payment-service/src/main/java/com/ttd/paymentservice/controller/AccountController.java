package com.ttd.paymentservice.controller;

import com.ttd.paymentservice.dto.AccountRequest;
import com.ttd.paymentservice.dto.AccountResponse;
import com.ttd.paymentservice.dto.TransferRequest;
import com.ttd.paymentservice.dto.TransferResponse;
import com.ttd.paymentservice.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hp ON 27-10-2023
 * @Description
 **/
@RestController
@RequestMapping("/v1/account")
public class AccountController {
    @Autowired
    private IAccountService accountService;
    @PostMapping("/transfer")
    public TransferResponse transferAmount(@RequestBody TransferRequest transferRequest){
        System.out.println(transferRequest.toString());
        return accountService.transferAmount(transferRequest);
    }

    @PostMapping("/save")
    public AccountResponse saveAccount(@RequestBody AccountRequest accountRequest){
        return accountService.saveAccount(accountRequest);
    }

}
