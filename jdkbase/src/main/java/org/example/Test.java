package org.example;

import jdk.jfr.Timespan;

import java.lang.annotation.Documented;
import java.util.LinkedList;
import java.util.List;

public class Test {
    public int add(@Param int a , int b ){
        return a + b;
    }


    public static void main(String[] args) {
        List<Apple> apples = new LinkedList<>();
        apples.add(new Apple("red"));
        apples.add(new Apple("yellow"));
        Apple apple1 = apples.stream().filter(apple -> "red".equals(apple.getColor())).findAny().orElse(null);
        System.out.println(apple1);

        Apple apple2 = apples.stream().filter(apple -> "red11".equals(apple.getColor())).findAny().orElse(null);
        System.out.println(apple2);

        Apple apple3 = apples.stream().filter(apple -> "yellow".equals(apple.getColor())).findAny().orElse(null);
        System.out.println(apple3);

    }
}
