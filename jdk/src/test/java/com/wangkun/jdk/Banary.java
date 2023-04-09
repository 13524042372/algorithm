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

    @Test
    public void banaryTest_1(){

        for (int i = 0; i < 10 ; i++){
            String s = Integer.toBinaryString(-1 >>> i );
            System.out.println(((-1 >>> i) + 1 ) + " " +s);
        }
    }

    @Test
    public void tableSizeTest(){
        for (int i = 0; i < 1000; i++) {
            int tableSizeFor = tableSizeFor(i);
            System.out.println(tableSizeFor);
        }
    }
    private static  int tableSizeFor(int c) {
        int n = -1 >>> Integer.numberOfLeadingZeros(c - 1);
        return (n < 0) ? 1 : (n >= Integer.MAX_VALUE) ? Integer.MAX_VALUE : n + 1;
    }
    @Test
    public void numberOfZore(){
        for(int i = 0; i < 1000; i++){
            System.out.println(Integer.numberOfLeadingZeros(i) + ":" + Integer.toBinaryString(i) );

        }
    }

}
