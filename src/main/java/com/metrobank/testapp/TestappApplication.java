package com.metrobank.testapp;

import com.metrobank.testapp.model.Accounts;
import com.metrobank.testapp.repository.AccountsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@ComponentScan(basePackages = "com.metrobank.testapp")

public class TestappApplication {
    @Autowired
    AccountsRepository accountsRepository;
    public static void main(String[] args) {

        SpringApplication.run(TestappApplication.class, args);
    }

}


