package com.ironhack.account;

import com.ironhack.dao.Account;
import org.junit.jupiter.api.BeforeEach;

class AccountTest {

    private Account accountUnderTest;

    @BeforeEach
    void setUp() {
        accountUnderTest = new Account(0L, 0, "city", "country");
    }
}
