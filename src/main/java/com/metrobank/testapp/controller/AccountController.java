package com.metrobank.testapp.controller;

import com.metrobank.testapp.model.Accounts;
import com.metrobank.testapp.repository.AccountsRepository;
import com.metrobank.testapp.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

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
    public Accounts findAccount(@PathVariable("accountId") String accountId) {
        // ModelAndView modelAndView = new ModelAndView("view/home");
        //modelAndView.addObject("message", accountService.processMessage("Greetings Stranger!"));

        //return modelAndView;

        return accountService.findById(Long.valueOf(accountId));
    }

    @GetMapping(path = "/allAccounts")
    public List<Accounts> getAllAccounts(){
        return accountService.findAll();
    }

    @PostMapping(path = "/createAccount")
    public Accounts createAccount(@RequestBody Accounts accounts) {
        return accountService.createAccount(accounts);

    }
}