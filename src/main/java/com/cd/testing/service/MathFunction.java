package com.cd.testing.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MathFunction {

    @Autowired
    DemoClass demoClass;

    public Integer add(Integer num1 , Integer num2){

        Integer result = num1 + num2;
        return result;


    }


    public String get(){
        return "Hello " + demoClass.getData();
    }


    public String toUpperCase(String s){
       return "Hi " + this.demoClass.data(s);
    }


    private String hello(){

        return "This is a void method";
    }


    public String getStatic(){
        String s = DemoClass.staticMethod();
        return s;
    }


    public String getPrivate(){
        String s = this.getPrivate();
        return s;
    }


    private String privateMethod(){
        return "This is a private method";
    }

}
