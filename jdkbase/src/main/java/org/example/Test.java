package org.example;

import jdk.jfr.Timespan;

import java.lang.annotation.Documented;

public class Test {
    public int add(@Param int a , int b ){
        return a + b;
    }
}
