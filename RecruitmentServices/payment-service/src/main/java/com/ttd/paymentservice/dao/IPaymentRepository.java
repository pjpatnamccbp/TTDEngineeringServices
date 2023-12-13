package com.ttd.paymentservice.dao;

import com.ttd.paymentservice.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author hp ON 27-10-2023
 * @Description
 **/
@Repository
public interface IPaymentRepository extends JpaRepository<Payment,Integer> {
}
