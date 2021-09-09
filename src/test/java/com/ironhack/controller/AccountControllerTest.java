
package com.ironhack.controller;

import com.ironhack.dao.Account;
import com.ironhack.enums.Industry;
import com.ironhack.repository.AccountRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class AccountControllerTest {
    @Autowired
    AccountRepository accountRepository;
    @Autowired
    AccountController accountController;

    @BeforeEach
    void setUp() {
        accountRepository.deleteAll();
    }

    @AfterEach
    void tearDown() {
        accountRepository.deleteAll();
    }

    @Test
    void createAccount_positive_accountCreated() {
        Account mockAccount = new Account(null,"Test_COMP",100, Industry.ECOMMERCE,"Poz","Pol",null);
        Account createdAccount = accountController.createAccount(mockAccount);
        assertEquals(1,accountRepository.findAll().size());
        assertEquals("Test_COMP", createdAccount.getCompanyName());
    }
    @Test
    void createAccount_positive_accountAlreadyExisted() {
        Account mockAccount = new Account(null,"Test_COMP2",100, Industry.ECOMMERCE,"Poz","Pol",null);
        accountController.createAccount(mockAccount);
        //This account was added one line ago
        Account createdAccount = accountController.createAccount(mockAccount);
        assertEquals(1,accountRepository.findAll().size());
        assertEquals("Test_COMP2", createdAccount.getCompanyName());
    }
    @Test
    void createAccount_negative_passingNull() {
        assertThrows(NullPointerException.class, () -> {
            accountController.createAccount(null);
        });
        assertEquals(0,accountController.findAllAccounts().size());
    }


    @Test
    void findAllAccounts_positive_correctNoOfAccounts() {
        //The findAll method is standard JPA method so not much testing is needed
        Account mockAccount1 = new Account(null,"Test_COMP1",100, Industry.ECOMMERCE,"Poz","Pol",null);
        Account mockAccount2 = new Account(null,"Test_COMP2",100, Industry.ECOMMERCE,"Poz","Pol",null);
        Account mockAccount3 = new Account(null,"Test_COMP3",100, Industry.ECOMMERCE,"Poz","Pol",null);
        accountRepository.save(mockAccount1);
        accountRepository.save(mockAccount2);
        accountRepository.save(mockAccount3);
        assertEquals(3,accountController.findAllAccounts().size());
    }

    @Test
    void findById_positive_foundCorrectAccount() {
        Account mockAccount1 = new Account(null,"Test_COMP_positive",100, Industry.ECOMMERCE,"Poz","Pol",null);
        Account mockAccount2 = new Account(null,"Test_COMP_bad",100, Industry.ECOMMERCE,"Poz","Pol",null);
        Account mockAccount3 = new Account(null,"Test_COMP_this_not",100, Industry.ECOMMERCE,"Poz","Pol",null);
        Account accountFromRepo = accountRepository.save(mockAccount1);
        accountRepository.save(mockAccount2);
        accountRepository.save(mockAccount3);
        Account foundAccount = accountController.findById(accountFromRepo.getAccountId());
        assertEquals(accountFromRepo.getCompanyName(),foundAccount.getCompanyName());
        assertEquals(accountFromRepo.getAccountId(),foundAccount.getAccountId());
    }
    @Test
    void findById_negative_accountNotFound() {
        //This shouldn't execute in prod code, because this method has to be used in pair with Commons class validation methods
        Account mockAccount1 = new Account(null,"Test_COMP7777",100, Industry.ECOMMERCE,"Poz","Pol",null);
        Account mockAccount2 = new Account(null,"Test_COMP8888",100, Industry.ECOMMERCE,"Poz","Pol",null);
        Account mockAccount3 = new Account(null,"Test_COMP9999",100, Industry.ECOMMERCE,"Poz","Pol",null);
        accountRepository.save(mockAccount1);
        accountRepository.save(mockAccount2);
        accountRepository.save(mockAccount3);
        //Account with large ID that won't be generated in tests
        assertThrows(IllegalArgumentException.class,()->{Account foundAccount = accountController.findById(77777777L);});
    }
}