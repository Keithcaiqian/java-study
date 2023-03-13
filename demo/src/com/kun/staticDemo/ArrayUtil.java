package com.kun.staticDemo;

public class ArrayUtil {
//    私有化，为了不让外界创建他的对象
    private ArrayUtil(){}

    public static String printArr(int[] arr){
        StringBuilder str = new StringBuilder();
        str.append('[');
        for (int i = 0; i < arr.length; i++) {
            if(i == arr.length - 1){
                str.append(arr[i]);
            }else {
                str.append(arr[i]).append(", ");
            }
        }
        str.append("]");
        return str.toString();
    }

    public static double getAverage(double[] arr){
        double num = 0;
        for (int i = 0; i < arr.length; i++) {
            num += arr[i];
        }
        return num / arr.length;
    }
}
