package com.ironhack;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
public class CRMApplicationTest {

    @MockBean
    private CRMApplication crmApplication;

    @Test
    public void contextLoads(){}
}
