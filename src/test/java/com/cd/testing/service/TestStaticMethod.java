package com.cd.testing.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestStaticMethod {

    @Autowired
    private MathFunction mathFunction;

    @Test
    public void testStaticMethod(){

        String expected = "This is a static method";

        try(MockedStatic<DemoClass> mockStatic = Mockito.mockStatic(DemoClass.class);){
            mockStatic.when(() -> DemoClass.staticMethod()).thenReturn("This is a static method");
            Assertions.assertEquals(expected,mathFunction.getStatic());
        }






    }

}
