package com.kun.classDemo;

public class DogTest {
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.setName("牛牛");
        dog.setAge(18);
        dog.call();
        dog.sleep();
        System.out.println(dog.getAge());

        Dog dog2 = new Dog(10, "笑话");
        dog2.sleep();
    }
}
