package com.metrobank.testapp.service;

import com.metrobank.testapp.model.Accounts;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AccountService {
    String processMessage(String input);
    Accounts createAccount(Accounts accounts);

    Accounts updateAccount (long accountId, Accounts accounts);

    Accounts findById(long accountId);

    Accounts findByMobileNumber(String mobileNumber);
    Accounts findByEmailAddress(String emailAddress);

    //Accounts findByEmailandMobileNumber(String emailAddress, String mobileNumber);

    List<Accounts> findAll();

    void deleteAccount(Long accountId);

}
