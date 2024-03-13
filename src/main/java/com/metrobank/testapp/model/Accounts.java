package com.metrobank.testapp.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
@Entity
@Table(schema = "metrobank-intern",name = "accounts")
@Data
public class Accounts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   // @SequenceGenerator(name ="account_id_seq", sequenceName = "account_id_seq", allocationSize = 50)
    @Column(name="account_id", nullable = false, columnDefinition = "serial")
    private Long accountId;

    //Name
    @Column(name="first_name")
    private String firstName;

    @Column(name="middle_name")
    private String middleName;

    @Column(name="last_name")
    private String lastName;

    //Contacts
    @Column(name="mobile_number")
    private String mobileNumber;

    @Column(name="telephone_number")
    private String telephoneNumber;

    @Column(name="email_address")
    private String emailAddress;

    //DOB
    @Column(name="date_of_birth")
    private String dateOfBirth;

    //Accounts Type
    @Column(name="checking_account")
    private Boolean checkingAccount;

    @Column(name="savings_account")
    private Boolean savingsAccount;

    @Column(name="money_market_account")
    private Boolean moneyMarketAccount;

    @Column(name="certificate_of_deposit_account")
    private Boolean certificateOfDepositAccount;


    //Address
    @Column(name="home_address_street")
    private String homeAddress_street;

    @Column(name="home_address_city")
    private String homeAddress_city;

    @Column(name="home_address_province")
    private String homeAddress_province;

    @Column(name="home_address_zip_code")
    private String homeAddress_zipCode;

    @Column(name="permanent_address_street")
    private String permanentAddress_street;

    @Column(name="permanent_address_city")
    private String permanentAddress_city;

    @Column(name="permanent_address_province")
    private String permanentAddress_province;

    @Column(name="permanent_address_zip_code")
    private String permanentAddress_zipCode;

    //MonthlySalary
    @Column(name="monthly_salary")
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


