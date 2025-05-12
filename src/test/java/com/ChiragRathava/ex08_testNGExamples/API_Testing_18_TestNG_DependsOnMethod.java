package com.ChiragRathava.ex08_testNGExamples;

import org.testng.Assert;
import org.testng.annotations.Test;

public class API_Testing_18_TestNG_DependsOnMethod {

    @Test
    public void serverStartedOk(){
        System.out.println(" I will run first");
        Assert.assertTrue(true);
    }

    @Test(dependsOnMethods = "serverStartedOk")
    public void method1(){
        System.out.println("methid1");
        Assert.assertTrue(true);
    }

    @Test(dependsOnMethods = "serverStartedOk")
    public void method2(){
        System.out.println("method2");
        Assert.assertTrue(true);
    }
}
