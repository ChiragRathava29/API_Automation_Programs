package com.ChiragRathava.ex08_testNGExamples;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class API_Testing_19_TestNG_Parameter {

    @Parameters("browser")
    @Test
    public void demo1(String value){
        System.out.println("Demo 1 TC");

        if(value.equalsIgnoreCase("chrome")){
            System.out.println("Start the chrome browser");
        }
        if(value.equalsIgnoreCase("firefox")){
            System.out.println("Start the firefox browser");
        }
    }
}
