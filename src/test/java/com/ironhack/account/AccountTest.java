package com.ironhack.account;

import org.junit.jupiter.api.BeforeEach;

class AccountTest {

    private Account accountUnderTest;

    @BeforeEach
    void setUp() {
        accountUnderTest = new Account(0, 0, "city", "country");
    }
}
