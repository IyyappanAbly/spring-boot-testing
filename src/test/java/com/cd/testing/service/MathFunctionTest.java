package com.cd.testing.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.util.ReflectionTestUtils;

@SpringBootTest
class MathFunctionTest {

  @Autowired
  private MathFunction mathFunction;

  @MockBean
  private DemoClass demoClass;

    @Test
    void testAdd(){

        // set up

        Integer expected = 2;

        // execute

        Integer actual = mathFunction.add(1,1);
        // assert

        Assertions.assertEquals(expected.intValue(), actual.intValue(), "Result does not matching");

    }

    @Test
    void testGet(){

        Mockito.when(demoClass.getData()).thenReturn("This is a demo class");

        String expected = "Hello This is a demo class";

        String actual = this.mathFunction.get();

        Assertions.assertEquals(expected,actual,"String is not matching");


    }


    @Test
    void testToUpperCase(){
        String input = "iyyappan";
        Mockito.when(this.demoClass.data(input)).thenReturn(input.toUpperCase());

        String expected = "Hi IYYAPPAN";


        String actual = this.mathFunction.toUpperCase(input);

        Assertions.assertEquals(expected,actual,"String is not matching");

    }


    @Test
    void testPrivateMethod(){
        String s = ReflectionTestUtils.invokeMethod(this.mathFunction,"hello");

        String expected = "This is a void method";

        Assertions.assertEquals(expected,s);

    }


}
