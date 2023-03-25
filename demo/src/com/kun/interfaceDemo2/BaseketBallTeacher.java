package com.kun.interfaceDemo2;

public class BaseketBallTeacher extends Teacher{
    public BaseketBallTeacher() {
    }

    public BaseketBallTeacher(String name, int age) {
        super(name, age);
    }

    @Override
    public void teach() {
        System.out.println("篮球教练在教打篮球");
    }
}
