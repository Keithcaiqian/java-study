package com.kun.polymorphicDemo;

public class Test {
    public static void main(String[] args) {
        Person person = new Person(25, "老王");
        Dog dog = new Dog(2, "黑");
        Cat cat = new Cat(2, "灰");
        person.keepPet(dog, "骨头");
        person.keepPet(cat, "鱼");
    }
}
