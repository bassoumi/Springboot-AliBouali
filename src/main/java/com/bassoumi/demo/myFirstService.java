package com.bassoumi.demo;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class myFirstService {

    private final MyFirstClass myFirstClass;

    public  myFirstService(
           @Qualifier("bean1") MyFirstClass myFirstClass
    ) {
        this.myFirstClass = myFirstClass;
    }


    public String tellaStory(){
        return "the dependency is saying: "+myFirstClass.sayHallow();

    }


}
