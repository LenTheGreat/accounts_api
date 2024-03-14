package com.metrobank.testapp.service.impl;

import com.metrobank.testapp.model.Accounts;
import com.metrobank.testapp.repository.AccountsRepository;
import com.metrobank.testapp.service.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor
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

        return accountsRepository.save(accounts);
    }

    //Read
    public Accounts findById(long accountId) {

        return accountsRepository.findById(accountId);
    }

    public List<Accounts> findAll() {
        return accountsRepository.findAll();
    }

    public Accounts findByMobileNumber(String mobileNumber) {
        return accountsRepository.findByMobileNumber(mobileNumber);
    }

    public Accounts findByEmailAddress(String emailAddress) {
        return accountsRepository.findByEmailAddress(emailAddress);
    }

  //Delete
    public void deleteAccount(Long accountId) {
        accountsRepository.deleteById(accountId);
    }
    //Update (mema)
    public Accounts updateAccount (long accountId, Accounts accounts){
        Optional<Accounts> accountsData = Optional.ofNullable(accountsRepository.findById(accountId));
        if(accountsData.isPresent()){
            Accounts _accounts = accountsData.get();
            _accounts.setFirstName(accounts.getFirstName());
            _accounts.setMiddleName(accounts.getMiddleName());
            _accounts.setLastName(accounts.getLastName());

            _accounts.setMobileNumber(accounts.getMobileNumber());
            _accounts.setTelephoneNumber(accounts.getTelephoneNumber());
            _accounts.setEmailAddress(accounts.getEmailAddress());

            _accounts.setMonthlySalary(accounts.getMonthlySalary());

            _accounts.setDateOfBirth(accounts.getDateOfBirth());

            _accounts.setCheckingAccount(accounts.getCheckingAccount());
            _accounts.setSavingsAccount(accounts.getSavingsAccount());
            _accounts.setMoneyMarketAccount(accounts.getMoneyMarketAccount());
            _accounts.setCertificateOfDepositAccount(accounts.getCertificateOfDepositAccount());

            _accounts.setHomeAddress_city(accounts.getHomeAddress_city());
            _accounts.setHomeAddress_street(accounts.getHomeAddress_street());
            _accounts.setHomeAddress_province(accounts.getHomeAddress_province());
            _accounts.setHomeAddress_zipCode(accounts.getHomeAddress_zipCode());

            _accounts.setPermanentAddress_city(accounts.getPermanentAddress_city());
            _accounts.setPermanentAddress_street(accounts.getPermanentAddress_street());
            _accounts.setPermanentAddress_province(accounts.getPermanentAddress_province());
            _accounts.setPermanentAddress_zipCode(accounts.getPermanentAddress_zipCode());

            return accountsRepository.save(_accounts);

        } else {
            return null;
    }

}

}



