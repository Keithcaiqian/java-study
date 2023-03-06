package com.kun.demo1;

import java.util.Scanner;

public class LoginDemo {
    public static void main(String[] args) {
        String userName = "admin";
        String password = "123456";

        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 3; i++) {
            System.out.println("请输入用户名");
            String name = sc.next();
            System.out.println("请输入密码");
            String pwd = sc.next();
            if(name.equals(userName) && pwd.equals(password)){
                System.out.println("登录成功");
                break;
            }
            else {
                System.out.println("输入错误");
            }
        }
    }
}
