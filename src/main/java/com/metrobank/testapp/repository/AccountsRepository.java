package com.metrobank.testapp.repository;

import com.metrobank.testapp.model.Accounts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface AccountsRepository extends JpaRepository<Accounts, Long> {
    Accounts findById(long accountId);
    List<Accounts> findAll();

    //Accounts createAccounts(Accounts accounts);


}
