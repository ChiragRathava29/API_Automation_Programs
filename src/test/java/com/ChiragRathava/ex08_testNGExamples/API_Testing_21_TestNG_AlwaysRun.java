package com.ChiragRathava.ex08_testNGExamples;

import org.testng.Assert;
import org.testng.annotations.Test;

public class API_Testing_21_TestNG_AlwaysRun {

    @Test(enabled = false)
    public void test01(){
        Assert.assertTrue(true);
    }

    @Test(alwaysRun = true, enabled = false)
    public void test02(){
        Assert.assertTrue(true);
    }

    @Test
    public void test03(){
        Assert.assertTrue(true);
    }
}
