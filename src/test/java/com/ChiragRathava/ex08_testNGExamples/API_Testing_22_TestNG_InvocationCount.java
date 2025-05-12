package com.ChiragRathava.ex08_testNGExamples;

import org.testng.Assert;
import org.testng.annotations.Test;

public class API_Testing_22_TestNG_InvocationCount {

    @Test(invocationCount = 15)
    public void test01(){
        Assert.assertTrue(true);
    }
}
