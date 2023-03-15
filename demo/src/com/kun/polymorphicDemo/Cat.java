package com.kun.polymorphicDemo;

public class Cat extends Animal{
    public Cat() {
    }

    public Cat(int age, String color) {
        super(age, color);
    }

    @Override
    public void eat(String something) {
        System.out.println(this.getAge() + "岁的" + this.getColor() + "颜色的猫咪着眼睛侧着头吃" + something);
    }

    public void catchMouse(){
        System.out.println("在逮老鼠");
    }
}
