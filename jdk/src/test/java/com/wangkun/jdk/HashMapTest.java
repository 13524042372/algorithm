package com.wangkun.jdk;

import org.junit.jupiter.api.Test;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapters;

public class HashMapTest {
    static final int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= Integer.MAX_VALUE) ? Integer.MAX_VALUE : n + 1;
    }

    @Test
    public void tableSizeForTest(){

    }

}
