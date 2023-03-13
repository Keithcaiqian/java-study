package com.kun.polymorphic;

public class Test {
    public static void main(String[] args) {
        Student s = new Student();
        Teacher t = new Teacher();
        register(s);
        register(t);
    }

    public static void register(Person p){
        p.show();
    }
}
