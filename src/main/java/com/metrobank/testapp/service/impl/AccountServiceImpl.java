package com.metrobank.testapp.service.impl;

import com.metrobank.testapp.model.Accounts;
import com.metrobank.testapp.repository.AccountsRepository;
import com.metrobank.testapp.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountsRepository accountsRepository;
    public String processMessage(String input) {
        String message = input +
                " - Service added me";

        return message;
    }
    //Create Account
    public Accounts createAccount(Accounts accounts) {
        return  accountsRepository.save(accounts);
    }

    //Read
    public Accounts findById(long accountId) {
        return accountsRepository.findById(accountId);
    }

    public List<Accounts> findAll(){

        return accountsRepository.findAll();
    }

    //Update

    //Delete
}
