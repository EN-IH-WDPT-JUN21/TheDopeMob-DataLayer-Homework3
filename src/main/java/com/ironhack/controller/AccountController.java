package com.ironhack.controller;

import com.ironhack.dao.Account;
import com.ironhack.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
public class AccountController {

    @Autowired
    AccountRepository accountRepository;

    public Account createAccount(Account account) {
        Optional<Account> foundAccount = accountRepository.findByCompanyName(account.getCompanyName());
        return foundAccount.isPresent() ?
                foundAccount.get() :
                accountRepository.save(account);
    }
    public List<Account> findAllAccounts() {
        return accountRepository.findAll();
    }

    public Account findById(Long id) {
        Optional<Account> foundAccount = accountRepository.findById(id);
        //Before using findById there should be a validation that guarantees the id will be valid, suggested use of the Commons class methods!
        if (foundAccount.isEmpty()){throw new IllegalArgumentException("The selected account disappeared, this shouldn't happen!");}
        else{return foundAccount.get();}
    }
}
