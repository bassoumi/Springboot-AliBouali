package com.bassoumi.demo;



public class MyFirstClass {

    private String myVar;

    public MyFirstClass(String myVar) {
        this.myVar = myVar;
    }

    public String sayHallow(){
       return "Hallow => " + myVar;
    }
}
