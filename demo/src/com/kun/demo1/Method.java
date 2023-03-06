package com.kun.demo1;

public class Method {

    public static void main(String[] args) {
        System.out.println("方法");
        method();
        int res = add(1, 2);
        System.out.println(res);
    }

    public static void method() {
        System.out.println("1111");
    }

    public static int add(int number1, int number2) {
        int result = number1 + number2;

        return result;
    }
}
