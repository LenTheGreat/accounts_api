package com.metrobank.testapp.service;

import com.metrobank.testapp.model.Accounts;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AccountService {
    String processMessage(String input);
    Accounts createAccount(Accounts accounts);

    Accounts findById(long accountId);

    List<Accounts> findAll();


}
