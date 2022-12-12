package com.twelvet.hand.sort;

import java.util.Arrays;

/**
 * @author twelvet
 * @WebSite www.twelvet.cn
 * @Description: 插入排序-依次往前对比即可
 */
public class InsertSort {

    public static void main(String[] args) {
        int[] arr = {3, 9, -1, 10, 12};
        insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            // 定义带插入的数
            int insertVal = arr[i];
            // 即arr[1]的前面这个数的下标
            int insertIndex = i - 1;

            // insertIndex >= 0 保证insertVal 找到插入位置不越界
            // insertVal < arr[insertIndex] 待插入的数，还没有找到插入位置
            // 就需要arr[insertIndex]后移
            while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }
            // 当退出while时说明插入位置找到，insertIndex - 1
            arr[insertIndex + 1] = insertVal;
        }
    }

}
