package com.ttd.paymentservice.dao;

import com.ttd.paymentservice.model.Account;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author hp ON 27-10-2023
 * @Description
 **/
public interface IAccountRepository extends JpaRepository<Account,String> {
    Optional<Account> findByCardNumber(String cardNumber);

    Optional<Account> findByCardNumberAndCvv(String cardNumber, String cvv);
}
