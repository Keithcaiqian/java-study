package com.kun.polymorphicDemo;

public class Person {
    private int age;
    private String name;

    public Person() {
    }

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public void keepPet(Dog dog, String something){
//        System.out.println("年龄为"+getAge()+"岁的" + getName() + "养了一只" + dog.getColor() + "颜色的" + dog.getAge() + "岁的狗");
//        dog.eat(something);
//    }
//    public void keepPet(Cat cat, String something){
//        System.out.println("年龄为"+getAge()+"岁的" + getName() + "养了一只" + cat.getColor() + "颜色的" + cat.getAge() + "岁的猫");
//        cat.eat(something);
//    }

//    多态方式
    public void keepPet(Animal animal, String something){
        String name;
        if(animal instanceof Dog){
            name = "狗";
        } else if (animal instanceof Cat) {
            name = "猫";
        }else {
            System.out.println("没有这种动物");
            return;
        }
        System.out.println("年龄为"+getAge()+"岁的" + getName() + "养了一只" + animal.getColor() + "颜色的" + animal.getAge() + "岁的" + name);
        animal.eat(something);
    }
}
