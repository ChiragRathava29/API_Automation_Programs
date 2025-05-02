package com.ChiragRathava.ex01_RA_Basic;

public class API_Testing_02 {
    public void step1(){
        System.out.println("Step 1");
    }

    public void step2(){
        System.out.println("Step 2");
    }

    public void step3(String param1){
        System.out.println("Step 3");
    }

    public static void main(String[] args) {

        // IT is a No chaining Pattern or simple pattern
        API_Testing_02 np = new API_Testing_02();
        np.step1();
        np.step2();
        np.step3("Chirag");
    }
}
