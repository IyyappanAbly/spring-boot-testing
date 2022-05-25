package com.cd.testing.service;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;

@SpringBootTest
public class TestMathFunction {

    @Autowired
    private MathFunction mathFunction;

    @SpyBean
    private DemoClass demoClass;

    @MockBean
    private ThirdClass thirdClass;


    @Test
    void testUpperCase(){

        String input = "penny";

        Mockito.when(this.demoClass.data(ArgumentMatchers.anyString())).thenReturn("PENNY");

        Mockito.when(thirdClass.get()).thenReturn("Third");

        String expected = "Hi PENNY Third";

        String actual = mathFunction.toUpperCase(input);

        Assertions.assertEquals(expected,actual,"String is not matching");




    }

}
