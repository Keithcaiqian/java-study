package com.kun.demo1;

public class Array1 {
    public static void main(String[] args) {
        int[] array1 = {1, 2, 3, 4};
        int[] array2 = new int[]{2, 3, 4, 6};

        System.out.println(array1); //打印的是地址值

//        快速生成这个代码
//        array2.fori
        for (int i = 0; i < array2.length; i++) {
            System.out.println(array2[i]);
        }

        //    动态初始化
        String[] arr3 = new String[50];
        arr3[0] = "liskk";
        System.out.println(arr3[0]);
        System.out.println(arr3[1]);

    }



}
