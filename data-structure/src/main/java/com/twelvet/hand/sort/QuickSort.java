package com.twelvet.hand.sort;

import java.util.Arrays;

/**
 * @author twelvet
 * @WebSite www.twelvet.cn
 * @Description: 快速排序(取出中间值左右各自排序递归即可)
 * 以中间值为标点，分别查找最大值和最小值交互，循环即可
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr, int left, int right) {
        int l = left;
        int r = right;
        // pivot中间值
        int pivot = arr[(left + right) / 2];
        // 临时变量作为交换时使用
        int temp;
        // while循环的目的是让比pivot值小放到左边
        while (l < r) {
            // 在pivot的左边一直找，找到大于pivot值，才退出
            while (arr[l] < pivot) {
                l += 1;
            }
            // 在pivot的右边一直找，找到小于等于pivot值，才退出
            while (arr[r] > pivot) {
                r -= 1;
            }
            if (l >= r) {
                break;
            }
            // 交换
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;

            // 如果交换完后，发现这个arr[l] == pivot值 相等 --前移动
            if (arr[l] == pivot) {
                r -= 1;
            }
            // 如果交换完后，发现这个arr[r] == pivot值 相等 ++前移动
            if (arr[r] == pivot) {
                l += 1;
            }
        }

        // 如果l == r, 必须l++, r--, 否则会出现栈溢出
        if (l == r) {
            l += 1;
            r -= 1;
        }
        // 向右递归
        if (left < r) {
            quickSort(arr, left, r);
        }
        // 右递归
        if (right > l) {
            quickSort(arr, l, right);
        }
    }

}
