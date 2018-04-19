package com.zdp.mathrithm;

import java.util.Random;

/**
 * 给你一个数组A[0..n]，请你在O(n)的时间里构造一个新的数组B[0..n]，使得B[i]=A[0]*A[1]*A[2]*…*A[n]/A[i]，但是不能使用除法运算。<br/>
 * 
 * @author： <a href="mailto:dapeng.zhou@qunar.com">dapeng.zhou<a/><br/>
 * @date： 2014年12月1日 下午4:19:10
 */
public class GoogleSuanfa {
    public static void main(String[] args) {
        // int[] array = { 1, 2, 3, 4, 5 };
        int[] array = getRandomArray(5);
        printArray(array);
        System.out.println("--------------");
        printArray(getArray(array));
    }

    public static int[] getRandomArray(int count) {
        if (count <= 0) {
            throw new RuntimeException("What do you want to do ?");
        }
        Random rd = new Random();
        int[] result = new int[count];
        for (int i = 0; i < count; i++) {
            result[i] = rd.nextInt(10);
        }
        return result;
    }

    public static void printArray(int[] array) {
        for (int a : array) {
            System.out.println(a);
        }
    }

    public static int[] getArray(int[] array) {
        int n = array.length;
        int[] before = new int[n];
        int[] after = new int[n];
        before[0] = 1;
        after[n - 1] = 1;
        for (int i = 1; i < n; i++) {
            before[i] = before[i - 1] * array[i - 1];
            after[n - 1 - i] = after[n - i] * array[n - i];
        }
        int[] newArray = new int[n];
        for (int i = 0; i < n; i++) {
            newArray[i] = before[i] * after[i];
        }
        return newArray;
    }
}
