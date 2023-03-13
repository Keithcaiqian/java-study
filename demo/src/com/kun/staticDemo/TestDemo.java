package com.kun.staticDemo;

import static com.kun.staticDemo.ArrayUtil.getAverage;
import static com.kun.staticDemo.ArrayUtil.printArr;

public class TestDemo {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5 };
        String arrString = printArr(arr); //ctrl + alt + v 快速生成
        System.out.println(arrString);

        double[] arr2 = { 1.2, 3.2, 8.1, 2.7 };
        double average = getAverage(arr2);
        System.out.println(average);

    }
}
