package com.kun.polymorphicDemo;

public class Dog extends Animal {
    public Dog() {
    }

    public Dog(int age, String color) {
        super(age, color);
    }

    @Override
    public void eat(String something) {
        System.out.println(this.getAge() + "岁的" + this.getColor() + "颜色的狗两只前腿死死的保住" + something + "猛吃");
    }

    public void lookHome(){
        System.out.println("在看家");
    }
}
