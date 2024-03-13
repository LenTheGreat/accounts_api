package com.metrobank.testapp.service;

import com.metrobank.testapp.model.Accounts;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AccountService {
    
    String processMessage(String input);

    //Method to create account
    Accounts createAccount(Accounts accounts);
    //Method to find an account using the id number
    Accounts findById(long accountId);
    //Method to view all account
    List<Accounts> findAll();


}
