package com.zdp.algorithm;

import java.util.Arrays;

/**
 * Created by dapeng.zhou on 2016/9/29.
 */
public class DictionarySort {
    public static void main(String[] args) {
        print(200,50);
    }

    public static void print(int n,int m) {
        int i = 1;
        int maxLength = 0;
        while (i <= n) {
            maxLength += i;
            i *= 10;
        }
        int firstDigit = n / (i / 10);
        System.out.println("firstDight=" + firstDigit);
        System.out.println("maxLength=" + maxLength);
        int preNumber = m / maxLength;
        System.out.println("preNumber=" + preNumber);
        int index = m % maxLength;
        int exceed = n - n / maxLength * maxLength;
        if (index < exceed) {
            int number = preNumber + 1;
            System.out.println("value=" + get(number,index));
            return;
        }
        int number = preNumber + 1 + (index - exceed) / (maxLength / 10) + 1;
        System.out.println("value=" + get(number,(index - exceed) % (maxLength / 10)));
    }

    /**
     *
     * @param number 以number开头
     * @param index 在以number开头的第几个
     * @return
     */
    public static int get(int number,int index) {
        int base = 1;
        while (base < index) {
            index -= base;
            base *= 10;
        }
        int data = base/10 * number + index % base;
        System.out.println("number=" + number + ",index=" + index + ",data=" + data);
        return data;
    }
}
