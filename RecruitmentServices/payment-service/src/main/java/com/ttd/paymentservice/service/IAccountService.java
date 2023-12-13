package com.ttd.paymentservice.service;

import com.ttd.paymentservice.dto.AccountRequest;
import com.ttd.paymentservice.dto.AccountResponse;
import com.ttd.paymentservice.dto.TransferRequest;
import com.ttd.paymentservice.dto.TransferResponse;

/**
 * @author hp ON 27-10-2023
 * @Description
 **/
public interface IAccountService {
    TransferResponse transferAmount(TransferRequest transferRequest);

    AccountResponse saveAccount(AccountRequest accountRequest);
}
