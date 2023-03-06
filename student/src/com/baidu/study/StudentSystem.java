package com.baidu.study;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentSystem {
    public static void main(String[] args) {

        ArrayList<Student> list = new ArrayList<>();

        while (true){
            System.out.println("------------------欢迎来到学生管理系统--------------------");
            System.out.println("1：添加学生");
            System.out.println("2: 删除学生");
            System.out.println("3: 修改学生");
            System.out.println("4: 查询学生");
            System.out.println("5: 退出学生");
            System.out.println("6: 请输入您的选择：");

            Scanner sc = new Scanner(System.in);
            String choose = sc.next();

            switch (choose){
                case "1" : addStudent(list) ; break;
                case "2" : deleteStudent(list); break;
                case "3" : updateStudent(list); break;
                case "4" : queryStudent(list); break;
                case "5" : System.out.println("退出学生"); return;
                default : System.out.println("没有这个选项"); break;
            }
        }
    }

    //    添加学生
    public static void addStudent(ArrayList<Student> list) {
        System.out.println("添加学生");
        Student stu  = new Student();
        Scanner sc = new Scanner(System.in);

        System.out.println("请输入学生的id");
        String id = null;
        while (true){
            id = sc.next();
            boolean flag = contains(list, id);
            if(flag){
                System.out.println("该学生id已存在，请重新输入");
            }else {
                stu.setId(id);
                break;
            }
        }

        System.out.println("请输入学生的姓名");
        String name = sc.next();
        stu.setName(name);

        System.out.println("请输入学生的年龄");
        int age = sc.nextInt();
        stu.setAge(age);

        System.out.println("请输入学生的家庭住址");
        String address =  sc.next();
        stu.setAddress(address);

        list.add(stu);

        System.out.println("添加学生成功");
    }

    //    删除学生
    public static void deleteStudent(ArrayList<Student> list) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入id");
        String sid = sc.next();
        int index = getIndex(list, sid);
        if(index >= 0){
            list.remove(index);
            System.out.println("删除成功");
        }else {
            System.out.println("id不存在，删除失败");
        }
    }

    //    修改学生
    public static void updateStudent(ArrayList<Student> list) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要修改学生的id");
        String sid = null;
        while (true){
            sid = sc.next();
            int index = getIndex(list, sid);
            if(index >= 0){
                Student stu = list.get(index);
                System.out.println("请输入要修改的学生姓名");
                String name = sc.next();
                stu.setName(name);

                System.out.println("请输入要修改的学生年龄");
                int age = sc.nextInt();
                stu.setAge(age);

                System.out.println("请输入要修改的学生家庭住址");
                String address = sc.next();
                stu.setAddress(address);

                System.out.println("修改成功");
                break;
            }else {
                System.out.println("id不存在，请重新输入id");
            }
        }
    }

    //    查询学生
    public static void queryStudent(ArrayList<Student> list) {

        if(list.size() == 0){
            System.out.println("当前没有学生信息，请添加后再查询");
            return;
        }
//        打印表头信息
        System.out.println("id\t\t姓名\t年龄\t家庭住址");

        for (int i = 0; i < list.size(); i++) {
            Student stu = list.get(i);
            System.out.println(stu.getId() + "\t\t" + stu.getName() + "\t" + stu.getAge() + "\t" + stu.getAddress());
        }
    }
//    根据id查询是否已经存在
    public static boolean contains(ArrayList<Student> list, String id){
//        for (int i = 0; i < list.size(); i++) {
//            Student stu = list.get(i);
//            String sid = stu.getId();
//            if(sid.equals(id)){
//                return true;
//            }
//        }
        return getIndex(list, id) >= 0;
    }
//    根据id查询索引
    public static int getIndex(ArrayList<Student> list, String id){
        for (int i = 0; i < list.size(); i++) {
            Student stu = list.get(i);
            String sid = stu.getId();
            if(sid.equals(id)){
                return i;
            }
        }
        return -1;
    }
}
