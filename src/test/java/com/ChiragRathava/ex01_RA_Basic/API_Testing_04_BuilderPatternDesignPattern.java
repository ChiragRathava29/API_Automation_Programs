package com.ChiragRathava.ex01_RA_Basic;

public class API_Testing_04_BuilderPatternDesignPattern {
    public API_Testing_04_BuilderPatternDesignPattern step1(){
        System.out.println("Step 1");
        return this;
    }

    public API_Testing_04_BuilderPatternDesignPattern step2(){
        System.out.println("Step 2");
        return this;
    }

    public API_Testing_04_BuilderPatternDesignPattern step3(String param){
        System.out.println("Step 3");
        return this;
    }

    public static void main(String[] args) {
        API_Testing_04_BuilderPatternDesignPattern bp = new API_Testing_04_BuilderPatternDesignPattern();
        bp.step1().step2().step3("Chirag");
    }
}
