package com.kun.demo1;

import java.util.ArrayList;

public class ArrayList1 {
    public static void main(String[] args) {
        ArrayList<String> arr = new ArrayList<String>();

        arr.add("aaa");
        arr.add("bbb");
        arr.add("ccc");
        arr.add("ddd");
        System.out.println(arr);

        arr.remove("aaa");
        System.out.println(arr);

        arr.remove(1);
        System.out.println(arr);

        arr.set(1, "ppp");
        System.out.println(arr);

        for (int i = 0; i < arr.size(); i++) {
            System.out.println(arr.get(i));
        }
    }
}
