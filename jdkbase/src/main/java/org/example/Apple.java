package org.example;

public class Apple {
    private String color;

    public Apple(String color){
        this.color = color;
    }
    public Apple(){
    }
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "color:" + color;
    }
}
