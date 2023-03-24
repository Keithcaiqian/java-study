package com.kun.interfaceDemo;

public class Pig extends Animal {

    public Pig() {
    }

    public Pig(String name, int age) {
        super(name, age);
    }

    @Override
    public void eat() {
        System.out.println("在吃白菜");
    }
}
