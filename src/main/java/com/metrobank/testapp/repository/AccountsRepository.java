package com.metrobank.testapp.repository;

import com.metrobank.testapp.model.Accounts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AccountsRepository extends JpaRepository<Accounts, Long> {
    //@Query( value = "SELECT * FROM Accounts a WHERE a.account_id = ?1", nativeQuery = true)
    Accounts findById(long accountId);
    //@Query( value = "SELECT * FROM Accounts a WHERE a.account_id = ?1 and a.email_address =?2")
    //Accounts findByIdAndEmail(long accountId, String emailAddress);
    List<Accounts> findAll();

    //@Query( value = "SELECT * FROM Accounts a WHERE a.email_address = ?1", nativeQuery = true)
    //Optional<Accounts> findAccountByEmail(String email);

}
