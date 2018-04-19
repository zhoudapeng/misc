package com.zdp.mathrithm.sort;

import com.qunar.mobile.car.common.util.JsonUtil;

/**
 * Created by dapeng.zhou on 2017/7/21.
 */
public class BubblingSort {
    public static void main(String[] args) {
        int[] array = {1,9,2,6,4,3,7};
        sort(array);
        System.out.println(JsonUtil.toJson(array));
    }

    private static void sort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                }
            }
        }
    }

    private static void swap(int[] array, int from, int to) {
        int temp = array[from];
        array[from] = array[to];
        array[to] = temp;
    }
}
