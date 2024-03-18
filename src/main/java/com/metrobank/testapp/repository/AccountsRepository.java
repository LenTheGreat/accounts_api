package com.metrobank.testapp.repository;

import com.metrobank.testapp.model.Accounts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface AccountsRepository extends JpaRepository<Accounts, Long> {
    Accounts findById(long accountId);
    Accounts findByEmailAddress(String emailAddress);
    Accounts findByMobileNumber(String mobileNumber);
    List<Accounts> findAll();




}
