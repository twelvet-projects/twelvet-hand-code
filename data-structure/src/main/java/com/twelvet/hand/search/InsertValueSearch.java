package com.twelvet.hand.search;

import java.util.Arrays;

/**
 * @author twelvet
 * @WebSite www.twelvet.cn
 * @Description: 、插值查找(要求数组是有序的)[使用公式递归]
 */
public class InsertValueSearch {

    public static void main(String[] args) {
        int[] arr = new int[100];
        for (int i = 0; i < 100; i++) {
            arr[i] = i + 1;
        }
        int i = insertValueSearch(arr, 0, arr.length - 1, 100);
        System.out.println(i);
    }

    /**
     * 公式 left + (right -left) * (findVal - arr[left]) / (arr[right] - arr[left])
     * @param arr     数组
     * @param left    左索引
     * @param right   右索引
     * @param findVal 查找值
     * @return 如果找到就返回对应下标，否则-1
     */
    public static int insertValueSearch(int[] arr, int left, int right, int findVal) {
        if (left > right || findVal < arr[0] || findVal > arr[arr.length - 1]) {
            return -1;
        }

        // 重要，求出中间值
        int mid = left + (right - left) * (findVal - arr[left]) / (arr[right] - arr[left]);

        int midVal = arr[mid];
        if (findVal > midVal) {
            // 向右递归
            return insertValueSearch(arr, mid + 1, right, findVal);
        } else if (findVal < midVal) {
            // 向左递归
            return insertValueSearch(arr, left, mid - 1, findVal);
        } else {
            return mid;
        }
    }

}
