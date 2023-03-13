package com.kun.extendsClass;

class Text {
    public static void main(String[] args) {
        Man m = new Man();
        m.eat();
    }
}

class Person {
    public void eat(){
        System.out.println("喜欢吃米饭");
    }
}

class Man extends Person{
//    重写
    @Override
    public void eat() {
        super.eat();
        System.out.println("喜欢吃大米饭");
    }
}
