package com.ttd.paymentservice.builder;

import com.ttd.paymentservice.dto.AccountRequest;
import com.ttd.paymentservice.dto.TransferRequest;
import com.ttd.paymentservice.dto.TransferResponse;
import com.ttd.paymentservice.model.Account;
import org.springframework.stereotype.Component;

/**
 * @author hp ON 27-10-2023
 * @Description
 **/
@Component
public class AccountRequestBuilder {
    /*public AccountRequest buildAccountRequest(TransferRequest transferRequest, Account savedAccount) {
        AccountRequest accountRequest = new AccountRequest();
        accountRequest.setAccountNo(savedAccount.getAccountNo());
        accountRequest.setCardNumber(savedAccount.getCardNumber());
        accountRequest.setCvv(savedAccount.getCvv());
        accountRequest.setAvailableBalance(savedAccountRequest);
    }*/

    public Account buildAccount(TransferRequest transferRequest, Account savedAccountDetails) {
        Account account = new Account();
        account.setAccountNo(savedAccountDetails.getAccountNo());
        account.setCardNumber(savedAccountDetails.getCardNumber());
        account.setCvv(savedAccountDetails.getCvv());
        account.setBank(savedAccountDetails.getBank());
        account.setAvailableBalance(savedAccountDetails.getAvailableBalance() - transferRequest.getAmount());
        return account;
    }

    public Account buildAccount(AccountRequest savedAccountDetails) {
        Account account = new Account();
        account.setAccountNo(savedAccountDetails.getAccountNo());
        account.setCardNumber(savedAccountDetails.getCardNumber());
        account.setCvv(savedAccountDetails.getCvv());
        account.setBank("SBI");
        account.setAvailableBalance(savedAccountDetails.getAvailableBalance());
        return account;
    }

    public TransferResponse buildTransferResponse() {
        TransferResponse transferResponse = new TransferResponse();
        transferResponse.setResponseMessage("Amount Transfer Succeeded");

        transferResponse.setResponseCode("0");
        return transferResponse;
    }
}
