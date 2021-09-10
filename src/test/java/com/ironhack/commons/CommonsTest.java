package com.ironhack.commons;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CommonsTest {
    @Test
    public void GetNumericInputFromUser_returns_int(){
        System.setIn(new ByteArrayInputStream("1".getBytes()));
        assertEquals(1,Commons.GetNumericInputFromUser("Please input 1 to pass the test"));
    }
    @Test
    public void GetNumericInputFromUser_pass_non_numeric_returns_int(){
        System.setIn(new ByteArrayInputStream("this is a work\n1".getBytes()));
        assertEquals(1,Commons.GetNumericInputFromUser("Please input 1 to pass the test"));
    }
    @Test
    public void GetNumericInputFromUserInRange_pass_in_range_returns_int(){
        System.setIn(new ByteArrayInputStream("5".getBytes()));
        assertEquals(5,Commons.GetNumericInputFromUserInRange("Please input 5 to pass the test",1,10));
    }
    @Test
    public void GetNumericInputFromUserInRange_pass_not_in_range_returns_int(){
        System.setIn(new ByteArrayInputStream("11\n14\n5".getBytes()));
        assertEquals(5,Commons.GetNumericInputFromUserInRange("Please input 5 to pass the test",1,10));
    }
    @Test
    public void GetNumericInputFromUserInRange_invalid_input_first_returns_int(){
        System.setIn(new ByteArrayInputStream("no\ndop\n-11111\n2343rtnwrgerjnf\n,,,,,...-2wor0o20\n11\n5456\n5".getBytes()));
        assertEquals(5,Commons.GetNumericInputFromUserInRange("Please input 5 to pass the test",1,10));
    }
    @Test
    void GetStringFromUserFromAvailable_positive_pickedCorrectlyAfterFewTries(){
        System.setIn(new ByteArrayInputStream("C\nCCC\nN".getBytes()));
        assertEquals("N",Commons.GetStringFromUserFromAvailable("Testing",new String[]{"N","X","Z"}));
    }
    @Test
    void GetLongFromUserFromAvailableOptions_positive_pickedCorrectlyAfterFewTries(){
        System.setIn(new ByteArrayInputStream("CCCC\nBAD INPUT\nLOMEFWFEW\n100\n13434\n-1111\n0ewfnmk344534\n2".getBytes()));
        List<Long> list = new ArrayList<>();
        list.add(1L);
        list.add(2L);
        list.add(3L);
        assertEquals(2L,Commons.GetLongFromUserFromAvailableOptions("Testing",list));
    }

}