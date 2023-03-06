package com.baidu.study;

public class Student {
    private String id;
    private String name;
    private int age;
    private String address;

//    alt + insert 选择第一个 再第一个
    public Student() {
    }

    //    alt + insert 选择第一个 回车 ctrl+a全选 回车
    public Student(String id, String name, int age, String address) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
    }

    //    alt + insert getter And Setter 回车 ctrl+a全选 回车
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
