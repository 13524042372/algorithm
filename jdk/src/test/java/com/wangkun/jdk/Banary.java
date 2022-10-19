package com.wangkun.jdk;

import org.junit.jupiter.api.Test;

public class Banary {

    @Test
    public void banaryTest(){
        for(int i = 0; i < 10; i++){
           // System.out.println(Integer.toBinaryString(i));
            System.out.println(i + " " + Integer.toBinaryString(-i));


        }
    }
}
