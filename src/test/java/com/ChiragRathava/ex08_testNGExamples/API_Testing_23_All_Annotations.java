package com.ChiragRathava.ex08_testNGExamples;

import org.testng.annotations.*;

public class API_Testing_23_All_Annotations {

    @BeforeSuite
    void demo1(){
        System.out.println("BeforeSuite");
    }

    @BeforeTest
    void demo2(){
        System.out.println("BeforeTest");
    }

    @BeforeClass
    void demo3(){
        System.out.println("BeforeTest");
    }

    @BeforeMethod
    void demo4(){
        System.out.println("BeforeMethod");
    }

    @Test
    void demo5(){
        System.out.println("Test");
    }

    @AfterMethod
    void demo6(){
        System.out.println("AfterMethod");
    }

    @AfterTest
    void demo7(){
        System.out.println("AfterTest");
    }

    @AfterTest
    void demo8(){
        System.out.println("AfterTest");
    }

    @AfterSuite
    void demo09(){
        System.out.println("AfterSuite");
    }
}
