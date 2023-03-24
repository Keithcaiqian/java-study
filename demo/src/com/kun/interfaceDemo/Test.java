package com.kun.interfaceDemo;

public class Test {
    public static void main(String[] args) {
        Pig p = new Pig("查理", 2);
        p.eat();

        Dog d = new Dog("牛牛", 5);
        d.eat();
        d.swim();
    }
}
