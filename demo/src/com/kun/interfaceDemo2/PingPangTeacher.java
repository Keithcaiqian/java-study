package com.kun.interfaceDemo2;

public class PingPangTeacher extends Teacher implements English{
    public PingPangTeacher() {
    }

    public PingPangTeacher(String name, int age) {
        super(name, age);
    }

    @Override
    public void english() {
        System.out.println("乒乓球教练在说英语");
    }

    @Override
    public void teach() {
        System.out.println("乒乓球教练在教打乒乓球");
    }
}
