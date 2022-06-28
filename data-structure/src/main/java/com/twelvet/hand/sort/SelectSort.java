package com.twelvet.hand.sort;

import java.util.Arrays;

/**
 * @author twelvet
 * @WebSite www.twelvet.cn
 * @Description: 、选择排序（每次循环选择最小的数值交换即可）
 */
public class SelectSort {

    public static void main(String[] args) {
        int[] arr = {3, 9, -1, 10, 12};
        selectSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void selectSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            int min = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                if (min > arr[j]) {
                    // 重置min
                    min = arr[j];
                    // 重置minIndex
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                arr[minIndex] = arr[i];
                arr[i] = min;
            }
        }


    }

}
