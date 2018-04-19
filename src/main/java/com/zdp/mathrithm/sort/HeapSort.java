package com.zdp.mathrithm.sort;

import com.qunar.mobile.car.common.util.JsonUtil;
import org.apache.lucene.util.ArrayUtil;

import java.util.Arrays;

/**
 * Created by dapeng.zhou on 2017/7/6.
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] array = {1, 4, 2, 6, 3, 200};
        System.out.println(JsonUtil.toJson(sort(array)));
    }

    private static int[] sort(int[] array) {
        int maxIndex = array.length - 1;
        for (int i = maxIndex; i > 0; i--) {
            for (int j = ((i - 1) / 2); j >= 0; j--) {
                int left = 2 * j + 1;
                int right = 2 * j + 2;
                if (left <= i && array[j] < array[left]) {
                    swap(array, left, j);
                }
                if (right <= i && array[j] < array[right]) {
                    swap(array, right, j);
                }
            }
            swap(array, 0, i);
        }
        return array;
    }

    private static void swap(int[] array, int from, int to) {
        System.out.println("swap " + "array[" + from + "] and array[" + to + "]");
        int temp = array[from];
        array[from] = array[to];
        array[to] = temp;
    }
}
