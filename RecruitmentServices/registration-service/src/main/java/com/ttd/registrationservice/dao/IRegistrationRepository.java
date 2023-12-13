package com.ttd.registrationservice.dao;

import com.ttd.registrationservice.model.Registration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author hp ON 27-10-2023
 * @Description
 **/
@Repository
public interface IRegistrationRepository extends JpaRepository<Registration,Integer> {
    Optional<Registration> findByEmailAndMobile(String email, String mobile);
}
