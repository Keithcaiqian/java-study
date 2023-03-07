package com.baidu.study;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<User> list = new ArrayList<>();
        while (true){
            System.out.println("欢迎来到学生管理系统");
            System.out.println("请选择操作：1登录 2注册 3忘记密码");

            String choose = sc.next();
            switch (choose){
                case "1":
//                    alt + enter生成函数
                    login(list);
                    break;
                case "2":
                    register(list);
                    break;
                case "3":
                    forgetPassword(list);
                    break;
                case "4":
                    System.out.println("谢谢使用，再见");
                    System.exit(0);
                    break;
                default:
                    System.out.println("没有在这个选项");
            }
        }

    }

    private static void forgetPassword(ArrayList<User> list) {
        System.out.println("请输入用户民");
        Scanner sc = new Scanner(System.in);
        String userName = sc.next();
        boolean flag = containsUserName(list,userName);
        if(!flag){
            System.out.println("当前用户不存在，请先去注册");
            return;
        }

        System.out.println("请输入省份证号码");
        String id = sc.next();
        System.out.println("请输入手机号");
        String phone = sc.next();

        int index = findIndex(list, userName);
        User user = list.get(index);
        if(!(user.getPersonID().equalsIgnoreCase(id) && user.getPhoneNumber().equals(phone))){
            System.out.println("身份证或手机号不正确，不能修改密码");
            return;
        }

        while (true) {
            System.out.println("请输入新的密码");
            String password = sc.next();
            System.out.println("请再次输入新的密码");
            String pwd2 = sc.next();
            if(password.equals(pwd2)){
                user.setPassword(password);
                System.out.println("两次输入一致");
                break;
            }else {
                System.out.println("两次输入不一致，请重新输入");
            }
        }

    }

    private static int findIndex(ArrayList<User> list, String userName) {
        for (int i = 0; i < list.size(); i++) {
            User u = list.get(i);
            if(u.getUsername().equals(userName)){
                return i;
            }
        }
        return -1;
    }

    private static void register(ArrayList<User> list) {
        System.out.println("注册");
        Scanner sc = new Scanner(System.in);
        User u = new User();

        System.out.println("请输入用户名");
        String name = null;
        while (true){
        // ctrl + alt + t 选择包裹语法
            name = sc.next();
            boolean flag = validateUserName(name);
            if(!flag){
                System.out.println("用户格式不正确，请输入用户名");
                continue;
            }

            //检验用户名唯一
            boolean flag2 = containsUserName(list, name);
            if(flag2){
                System.out.println("用户名已存在请重新输入");
            } else {
                u.setUsername(name);
                break;
            }
        }

        //密码
        while (true) {
            System.out.println("请输入要注册的密码");
            String pw = sc.next();
            System.out.println("请再次输入要注册的密码");
            String pw2 = sc.next();
            if(!pw.equals(pw2)){
                System.out.println("两此输入不一致，请再次输入");
            }else {
                u.setPassword(pw);
                break;
            }
        }

        //身份证号
        while (true) {
            System.out.println("请输入身份证号");
            String id = sc.next();
            boolean flag = validateId(id);
            if(flag){
                u.setPersonID(id);
                break;
            }else{
                System.out.println("身份证格式错误请重新输入");
            }
        }

        //手机号码
        while (true) {
            System.out.println("请输入手机号码");
            String phoneNumber = sc.next();

            boolean flag = validatePhoneNumber(phoneNumber);
            if(flag){
                System.out.println("手机号码正确");
                u.setPhoneNumber(phoneNumber);
                break;
            }else {
                System.out.println("手机号码格式错误，请重新输入");
            }
        }

        list.add(u);
        System.out.println("添加成功");

        printList(list);
    }

    private static void printList(ArrayList<User> list) {
        for (int i = 0; i < list.size(); i++) {
            User u = list.get(i);
            System.out.println(u.getUsername() + ", " + u.getPassword() + ", " + u.getPersonID() + ", " +  u.getPhoneNumber());
        }
    }

    private static boolean validatePhoneNumber(String phoneNumber) {
        if(phoneNumber.length() != 11){
            return  false;
        }

        if(phoneNumber.startsWith("0")){
            return  false;
        }

        for (int i = 0; i < phoneNumber.length(); i++) {
            char c = phoneNumber.charAt(i);
            if(!(c >= '0' && c <= '9')){
                return false;
            }
        }

        return true;
    }

    private static boolean validateId(String id) {
        if(id.length() != 18){
            return false;
        }

        if(!id.startsWith("1")){
            return false;
        }

        for (int i = 0; i < 17; i++) {
            char c = id.charAt(i);
            if(!(c >= '0' && c <= '9')){
                return false;
            }
        }

        char last = id.charAt(17);
        if((last >= '0' && last <= '9') || (last == 'x' || last == 'X')){
            return true;
        }
        return false;
    }

    private static boolean containsUserName(ArrayList<User> list, String name) {
        for (int i = 0; i < list.size(); i++) {
            User user = list.get(i);
            if(user.getUsername().equals(name)){
                return true;
            }
        }
        return false;
    }

    //    校验username
    private static boolean validateUserName(String name) {
//        校验长度
        int len = name.length();
        if(len < 3 || len > 18){
            return false;
        }
//        校验字母和数字
        for (int i = 0; i < len; i++) {
            char c = name.charAt(i);
            if(!((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9'))){
                return false;
            }
        }
//        不能是纯数字
        int count = 0;
        for (int i = 0; i < len; i++) {
            char c = name.charAt(i);
            if((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')){
                return true;
            }else {
                count++;
            }
        }

        return count != len;
    }

    private static void login(ArrayList<User> list) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名");
        String user = sc.next();
        boolean flag =  containsUserName(list, user);
        if(!flag){
            System.out.println("用户名" + user + "未注册，请先注册");
            return;
        }

        System.out.println("请输入密码");
        String pwd = sc.next();

        while (true) {
            String rightCode = getCode();
            System.out.println("当前正确的验证码为：" + rightCode);
            System.out.println("请输入验证码");
            String code = sc.next();
            if(code.equalsIgnoreCase(rightCode)){
                System.out.println("验证码正确");
                break;
            }else {
                System.out.println("验证码错误，请重新输入");
            }
        }

        User userInfo = new User(user, pwd, null, null);
        boolean res = checkUserInfo(list, userInfo);
        if(res) {
            System.out.println("登录成功");
            StudentSystem ss = new StudentSystem();
            ss.startStudentSystem();
        }else {
            System.out.println("登录失败，用户名或密码错误");
        }
    }

    private static boolean checkUserInfo(ArrayList<User> list, User userInfo) {
        for (int i = 0; i < list.size(); i++) {
            User u = list.get(i);
            if(u.getUsername().equals(userInfo.getUsername()) && u.getPassword().equals(userInfo.getPassword())){
                return true;
            }
        }
        return false;
    }

    //生成一个验证码, 长度为5
    private static String getCode(){
        ArrayList<Character> list = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            list.add((char)('a' + i));
            list.add((char)('A' + i));
        }

        StringBuilder sb = new StringBuilder();

        Random r = new Random();
        for (int i = 0; i < 4; i++) {
            int index =  r.nextInt(list.size());
            char c = list.get(index);
            sb.append(c);
        }

        int number = r.nextInt(10);
        sb.append(number);

        char[] arr = sb.toString().toCharArray();
        int randomIndex = r.nextInt(arr.length);
        char temp  = arr[randomIndex];
        arr[randomIndex] = arr[arr.length - 1];
        arr[arr.length - 1] = temp;

        return new String(arr);
    }
}
