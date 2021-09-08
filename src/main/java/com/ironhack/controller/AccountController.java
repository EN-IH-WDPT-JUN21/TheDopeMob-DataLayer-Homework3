package com.ironhack.controller;

import com.ironhack.dao.Account;
import com.ironhack.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

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
}
