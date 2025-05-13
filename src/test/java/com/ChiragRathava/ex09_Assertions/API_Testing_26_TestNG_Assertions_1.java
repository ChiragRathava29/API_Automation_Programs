package com.ChiragRathava.ex09_Assertions;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class API_Testing_26_TestNG_Assertions_1 {

    // Hard Assertion
    @Test
    public void test_hardAssertExample(){
        System.out.println("Start of the program");
        Boolean is_neeru_male = false;
        Assert.assertEquals("chirag","Chirag");
        System.out.println("End of the program");
    }
    /* It is a break at a fail  */


    // Software Assertion

}
