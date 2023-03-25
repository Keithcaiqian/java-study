package com.kun.interfaceDemo2;

public class BaseketBallSporter extends Sporter{
    public BaseketBallSporter() {
    }

    public BaseketBallSporter(String name, int age) {
        super(name, age);
    }

    @Override
    public void study() {
        System.out.println("篮球运动员在学打篮球");
    }
}
