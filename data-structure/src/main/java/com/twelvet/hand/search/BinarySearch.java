package com.twelvet.hand.search;

/**
 * @author twelvet
 * @WebSite www.twelvet.cn
 * @Description: 二分查找(该数组必须是有序的前提)[切割两个数组，判断在索引还是右索引，进行遍历即可]
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        int i = binarySearch(arr, 0, arr.length - 1, 8);
        System.out.println("下标为" + i);
    }

    /**
     * 二分查找
     *
     * @param arr     数组
     * @param left    左边索引
     * @param right   右边索引
     * @param findVal 需要查找的值
     * @return 如果找到就返回下标，如果没有找到就返回-1
     */
    public static int binarySearch(int[] arr, int left, int right, int findVal) {

        // 当left > right 时，说明递归整个数组，但是没有找到
        if (left > right) {
            return -1;
        }

        int mid = (left + right) / 2;
        int midVal = arr[mid];

        // 向右递归
        if (findVal > midVal) {
            return binarySearch(arr, mid + 1, right, findVal);
        } else if (findVal < midVal) {
            return binarySearch(arr, left, mid - 1, findVal);
        } else {
            return mid;
        }
    }

}
