package com.twelvet.hand.sort;

import java.util.Arrays;

/**
 * @author twelvet
 * @WebSite www.twelvet.cn
 * @Description: 冒泡排序
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = {3, 9, -1, 10, 12};

        bubbleSort(arr);

        System.out.println(Arrays.toString(arr));
    }

    public static void bubbleSort(int[] arr) {
        int temp = 0;
        boolean flag = false;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    flag = true;
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }

            if (!flag) {
                // 在一趟排序种，一次交换都没有发生过，退出本次排序
                break;
            } else {
                // 重置flag，进行下一次判断
                flag = false;
            }
        }
    }

}
