package com.ChiragRathava.ex08_testNGExamples;

import org.testng.annotations.*;

public class API_Testing_24_All_Annotations {

    @BeforeSuite
    void demo1(){
        System.out.println("Read the data from the MySQL");
    }

    @BeforeTest
    void demo2(){
        System.out.println("Data in Matrix, TC Before");
    }

    @BeforeClass
    void demo3(){
        System.out.println("BeforeClass");
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
