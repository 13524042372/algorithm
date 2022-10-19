package com.wangkun.jdk;


import org.junit.jupiter.api.Test;

public class ConcurrentHashMapTest {

    @Test
    public void resizeStampTest(){
        System.out.println(Integer.toBinaryString(1 << (16 - 1)));
        int i = Integer.numberOfLeadingZeros(1) | (1 << (16 - 1));
        System.out.println(i);
    }


    @Test
    public void toBinaryStringTest() {
        // System.out.println(Integer.toBinaryString(-10 ));
        for (int n = 1; n < 1000000; n *= 2) {
            int rs = resizeStamp(n);
            for(int i = 1; i < 10; i++) {
                int ans = (rs << RESIZE_STAMP_SHIFT) + i;
                // System.out.println("n:" + n + "    rs:" + rs + "  ans:" + ans);
                System.out.println("n:" + n + "    rs:" + Integer.toBinaryString(rs) +
                        "  ans:" + Integer.toBinaryString(ans).substring(0, 16) + " " + Integer.toBinaryString(ans).substring(16)
                        + " i = " + i + " ans :" + ans);
            }

        }
    }

    static final int resizeStamp(int n) {
        int zeroCount = Integer.numberOfLeadingZeros(n);
        return Integer.numberOfLeadingZeros(n) | (1 << (RESIZE_STAMP_BITS - 1));
    }
    private static int RESIZE_STAMP_BITS = 16;

    private static final int RESIZE_STAMP_SHIFT = 32 - RESIZE_STAMP_BITS;
    public static void main(String[] args) {
        // <0 时溢出，结束
        for(int n=1;n>0;n*=2){
            int rs = resizeStamp(n);
            int ans = (rs << RESIZE_STAMP_SHIFT) + 2;
            System.out.println("n:"+n+"    rs:"+rs+"  ans:"+ans);
        }
    }

    @Test
    public void toBinaryStringTest_1() {
        // System.out.println(Integer.toBinaryString(-10 ));
        for (int n = 1; n > 0; n *= 2) {
            System.out.println(Integer.toBinaryString(-n) + "  " + Integer.toBinaryString(n));
        }
    }
}
