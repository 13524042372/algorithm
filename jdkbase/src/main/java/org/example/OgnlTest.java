package org.example;

import ognl.Ognl;
import ognl.OgnlException;

public class OgnlTest {
    private String name;

    private Apple apple;

    public Apple getApple() {
        return apple;
    }

    public void setApple(Apple apple) {
        this.apple = apple;
    }

    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    public static void main(String[] args) throws OgnlException {
        OgnlTest ognl = new OgnlTest();
        Ognl.setValue(Ognl.parseExpression("name"),ognl,"wangkun");
        System.out.println(ognl.name);
        Ognl.setValue(Ognl.parseExpression("name"),ognl,null);
        System.out.println(ognl.name);
        System.out.println("************");
       // System.out.println(ognl.getApple().getColor());
        Ognl.setValue(Ognl.parseExpression("apple"),ognl,new Apple());

        Ognl.setValue(Ognl.parseExpression("apple.color"),ognl,"yellow");
        System.out.println(ognl.getApple().getColor());


    }
}
