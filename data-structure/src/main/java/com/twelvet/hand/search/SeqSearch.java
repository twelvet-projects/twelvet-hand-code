package com.twelvet.hand.search;

/**
 * @author twelvet
 * @WebSite www.twelvet.cn
 * @Description: 、线性查找
 */
public class SeqSearch {

    public static void main(String[] args) {
        // 没有顺序的数组
        int[] arr = {1, 9, 11, -1, 34, 89};
        int index = seqSearch(arr, 11);
        if (index == -1) {
            System.out.println("没有找到");
        } else {
            System.out.println("找到，下标为=" + index);
        }
    }

    /**
     * 实现线性查找，找到一个满足返回
     *
     * @param arr   数组
     * @param value 需要的值
     * @return 返回值
     */
    public static int seqSearch(int[] arr, int value) {
        // 线性查找是逐一，发现有相同值，就返回下标
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) {
                return i;
            }
        }
        return -1;
    }

}
