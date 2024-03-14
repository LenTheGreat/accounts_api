package com.metrobank.testapp.controller;

import com.metrobank.testapp.model.Accounts;
import com.metrobank.testapp.repository.AccountsRepository;
import com.metrobank.testapp.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accounts")
@Controller
public class AccountController {
    @Autowired
    private AccountService accountService;

    @Autowired
    AccountsRepository accountsRepository;

    @GetMapping(path = "/findAccount/{accountId}")
    public Accounts findAccount(@PathVariable("accountId") long accountId) {
        // ModelAndView modelAndView = new ModelAndView("view/home");
        //modelAndView.addObject("message", accountService.processMessage("Greetings Stranger!"));

        //return modelAndView;

        return accountService.findById(accountId);
    }

    @GetMapping(path = "/allAccounts")
    public List<Accounts> getAllAccounts(){
        return accountService.findAll();
    }

    //Create Account
    @PostMapping(path = "/createAccount")
    public ResponseEntity<String> createAccount(@RequestBody Accounts accounts) {
        Accounts existingEmailAddress = accountService.findByEmailAddress(accounts.getEmailAddress());
        Accounts existingMobileNumber = accountService.findByMobileNumber(accounts.getMobileNumber());

        if(existingEmailAddress == null && existingMobileNumber == null){
            accountService.createAccount(accounts);
            return ResponseEntity.status(HttpStatus.OK).body("Account created succesfully");
        }
        else{
            return ResponseEntity.status(HttpStatus.CONFLICT).body("An account with the same email address or mobile number already exists");
        }


    }
}