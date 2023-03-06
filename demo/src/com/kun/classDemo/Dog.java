package com.kun.classDemo;

public class Dog {
    private int age;
    private String name;

    //快捷键 alt + insert

    public Dog(){
        System.out.println("无参构造");
    }

    public Dog(int age, String name){
        this.setAge(age);
        this.setName(name);
        System.out.println("有参构造，重载");
    }

    public void setAge(int age){
        if(age > 0 && age < 20){
            this.age = age;
        }else {
            this.age = 0;
        }
    }
    public int getAge(){
        return this.age;
    }

    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }

    public void call(){
        System.out.println("狗叫");
    }

    public void sleep(){
        System.out.println("睡觉");
    }
}
