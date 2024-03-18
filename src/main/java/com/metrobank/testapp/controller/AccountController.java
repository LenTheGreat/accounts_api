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
    public  AccountService accountService;

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

    //Delete Account
    @DeleteMapping(path = "/deleteAccount/{accountId}")
    public ResponseEntity<String> deleteAccount(@PathVariable("accountId") Long accountId){
        accountService.deleteAccount(accountId);
        return ResponseEntity.ok("Account deleted successfully");
    }

    // Update Account (mema)
    @PutMapping(path ="/updateAccount/{accountId}")
    public ResponseEntity<String>  updateAccount(@PathVariable("accountId") long accountId, @RequestBody Accounts accounts){
        Accounts existingEmailAddress = accountService.findByEmailAddress(accounts.getEmailAddress());
        Accounts existingMobileNumber = accountService.findByMobileNumber(accounts.getMobileNumber());

        Accounts existingAccount = accountService.findById(accountId);

        //Check if there is an existing account
        if(existingAccount == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Account does not exist");
        }

        //Check if there are existing email address or mobile number
        if((existingEmailAddress != null && existingEmailAddress.getAccountId() != accountId) ||
                (existingMobileNumber != null && existingMobileNumber.getAccountId() != accountId)){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("An account with the same email address or mobile number already exists");
        }

        //Update Account
        accountService.updateAccount(accountId, accounts);
        return ResponseEntity.status(HttpStatus.OK).body("Account updated successfully");
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