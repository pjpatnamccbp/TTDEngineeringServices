package com.ttd.paymentservice.service;

import com.ttd.paymentservice.builder.AccountRequestBuilder;
import com.ttd.paymentservice.dao.IAccountRepository;
import com.ttd.paymentservice.dto.AccountRequest;
import com.ttd.paymentservice.dto.AccountResponse;
import com.ttd.paymentservice.dto.TransferRequest;
import com.ttd.paymentservice.dto.TransferResponse;
import com.ttd.paymentservice.exception.CardNotValidException;
import com.ttd.paymentservice.exception.InsufficientBalanceException;
import com.ttd.paymentservice.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author hp ON 27-10-2023
 * @Description
 **/
@Service
public class AccountServiceImpl implements IAccountService {
    @Autowired
    private IAccountRepository accountRepository;

    @Autowired
    private AccountRequestBuilder accountRequestBuilder;
    @Override
    public TransferResponse transferAmount(TransferRequest transferRequest) {
        Account savedAccountDetails = accountRepository.findByCardNumberAndCvv(transferRequest.getCardNumber(),transferRequest.getCvv())
                .orElseThrow(() -> new CardNotValidException(String.format("card number %s not valid",transferRequest.getCardNumber())));

        /*Optional<Account> optionalSavedAccountDetails = accountRepository.findByCardNumber(transferRequest.getCardNumber());


        Account savedAccountDetails = null;
        if(optionalSavedAccountDetails.isPresent()){
            savedAccountDetails = optionalSavedAccountDetails.get();
            System.out.println(savedAccountDetails.toString());
        }else{
            throw new CardNotValidException(String.format("card number %s not valid",transferRequest.getCardNumber()));
        }*/

        if(transferRequest.getAmount() > savedAccountDetails.getAvailableBalance()){
            throw new InsufficientBalanceException(String.format("available balance is %f, can't transfer %f",
                    savedAccountDetails.getAvailableBalance(),transferRequest.getAmount()));
        }
        accountRepository.save(accountRequestBuilder.buildAccount(transferRequest,savedAccountDetails));

        return accountRequestBuilder.buildTransferResponse();
    }

    @Override
    public AccountResponse saveAccount(AccountRequest accountRequest) {
        Account savedAccount = accountRepository.save(accountRequestBuilder.buildAccount(accountRequest));

        AccountResponse accountResponse = new AccountResponse();
        accountResponse.setResponseMessage("added");
        accountResponse.setStatus("Active");
        accountResponse.setAvailableBalance(savedAccount.getAvailableBalance());
        return accountResponse;
    }
}
