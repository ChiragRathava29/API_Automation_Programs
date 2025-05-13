package com.ChiragRathava.ex09_Assertions;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class API_Testing_26_TestNG_Assertions_2 {

    // Hard Assertion

    // Software Assertion
    @Test
    public void test_softAssertExample(){
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(false);
        System.out.println("End of the program");
        softAssert.assertAll();
    }
    /* It is a continue after a fail.  */

}
