package com.ChiragRathava.ex08_testNGExamples;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class API_Testing_15_BeforeTest {

    @BeforeTest
    public void getToken(){
        System.out.println("1");
    }

    @BeforeTest
    public void getBookingID(){
        System.out.println("2");
    }

    @Test
    public void test_PUT(){
        // token & BookingID
        System.out.println("3");
    }

    @AfterTest
    public void closeAllThings(){
        System.out.println("close");
    }
}
