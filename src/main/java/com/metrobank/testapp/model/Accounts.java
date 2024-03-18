package com.metrobank.testapp.model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import org.jetbrains.annotations.NotNull;

import java.util.Date;
@Entity
@Builder
@Table(schema = "metrobank-intern",name = "accounts")
@Data
public class Accounts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="account_id", nullable = false, columnDefinition = "serial")
    private Long accountId;

    //Name
    @Column(name="first_name", nullable = false)
    private String firstName;

    @Column(name="middle_name", nullable = false)
    private String middleName;

    @Column(name="last_name",nullable = false)
    private String lastName;

    //Contacts
    @Column(name="mobile_number",nullable = false)
    private String mobileNumber;

    @Column(name="telephone_number",nullable = true)
    private String telephoneNumber;

    @Column(name="email_address",nullable = false)
    private String emailAddress;

    //DOB
    @Column(name="date_of_birth",nullable = false)
    private String dateOfBirth;

    //Accounts Type
    @Column(name="checking_account", nullable = false)
    private Boolean checkingAccount;

    @Column(name="savings_account", nullable = false)
    private Boolean savingsAccount;

    @Column(name="money_market_account", nullable = false)
    private Boolean moneyMarketAccount;

    @Column(name="certificate_of_deposit_account", nullable = false)
    private Boolean certificateOfDepositAccount;


    //Address
    @Column(name="home_address_street", nullable = false)
    private String homeAddress_street;

    @Column(name="home_address_city", nullable = false)
    private String homeAddress_city;

    @Column(name="home_address_province", nullable = false)
    private String homeAddress_province;

    @Column(name="home_address_zip_code", nullable = false)
    private String homeAddress_zipCode;

    @Column(name="permanent_address_street", nullable = false)
    private String permanentAddress_street;

    @Column(name="permanent_address_city", nullable = false)
    private String permanentAddress_city;

    @Column(name="permanent_address_province", nullable = false)
    private String permanentAddress_province;

    @Column(name="permanent_address_zip_code", nullable = false)
    private String permanentAddress_zipCode;

    //MonthlySalary
    @Column(name="monthly_salary", nullable = false)
    private double monthlySalary;

    public Accounts(long accountId, String firstName, String middleName, String lastName, String mobileNumber, String telephoneNumber, String emailAddress, String dateOfBirth, boolean checkingAccount, boolean savingsAccount, boolean moneyMarketAccount, boolean certificateOfDepositAccount, String homeAddress_street, String homeAddress_city, String homeAddress_province, String homeAddress_zipCode, String permanentAddress_street, String permanentAddress_city, String permanentAddress_province, String permanentAddress_zipCode, double monthlySalary){

        //Account ID
        this.accountId = accountId;

        //Name
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;

        //Contacts
        this.mobileNumber = mobileNumber;
        this.telephoneNumber = telephoneNumber;
        this.emailAddress = emailAddress;

        //Date of Birth
        this.dateOfBirth = dateOfBirth;

        //Type of Accounts
        this.checkingAccount = checkingAccount;
        this.savingsAccount = savingsAccount;
        this.moneyMarketAccount = moneyMarketAccount;
        this.certificateOfDepositAccount = certificateOfDepositAccount;

        //Home Address
        this.homeAddress_street = homeAddress_street;
        this.homeAddress_city = homeAddress_city;
        this.homeAddress_province = homeAddress_province;
        this.homeAddress_zipCode = homeAddress_zipCode;

        //Permanent Address
        this.permanentAddress_street = permanentAddress_street;
        this.permanentAddress_city = permanentAddress_city;
        this.permanentAddress_province = permanentAddress_province;
        this.permanentAddress_zipCode = permanentAddress_zipCode;

        //Monthly Salary
        this.monthlySalary = monthlySalary;
    }

    public Accounts(){}
}


