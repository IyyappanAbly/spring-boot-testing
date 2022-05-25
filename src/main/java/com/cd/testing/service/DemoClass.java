package com.cd.testing.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DemoClass {

    @Autowired
    private ThirdClass thirdClass;

    public String getData(){
        return "This is a demo class";
    }


    public String data(String s ){

        return s.toUpperCase() + " " + thirdClass.get();
    }


    public static String staticMethod(){
        return "This is a static method";
    }

}
