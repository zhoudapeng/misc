package com.zdp.mathrithm.sort;

import com.qunar.mobile.car.common.util.JsonUtil;

/**
 * Created by dapeng.zhou on 2017/7/21.
 */
public class FastSort {
    public static void main(String[] args) {
        int[] array = {7,1,6,2,4,5,3,8};
        quickSort(array,0,array.length - 1);
        System.out.println(JsonUtil.toJson(array));
    }

    private static void quickSort(int[] array, int low, int high) {
        if (low >= high) {
            return;
        }
        int i = low;
        int j = high;
        int current = array[low];
        while (i < j) {
            while (i < j && array[j] >= current) {
                j--;
            }
            if (i < j) {
                array[i++] = array[j];
            }
            while (i < j && array[i] < current) {
                i++;
            }
            if (i < j) {
                array[j--] = array[i];
            }
        }
        array[i] = current;
        quickSort(array,low,i-1);
        quickSort(array,i+1,high);
    }
}
