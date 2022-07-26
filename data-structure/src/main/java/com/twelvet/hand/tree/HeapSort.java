package com.twelvet.hand.tree;

import java.util.Arrays;

/**
 * @author twelvet
 * <p>
 * 堆排序
 */
public class HeapSort {

    public static void main(String[] args) {
        int[] arr = {4, 6, 8, 5, 9};
        heapSort(arr);
    }

    public static void heapSort(int[] arr) {
        int temp;
        System.out.println("堆排序");
        // 将无序序列建成一个堆，根据升序降序需求选择大顶堆或者小顶堆
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjustHeap(arr, i, arr.length);
        }

        // 将堆顶原生与末尾交换，将最大原生沉到数组尾端
        // 重新调整结构，使其满足堆定义，然后继续交换堆顶原生与当前末尾元素，反复执行调整+交换步骤，知道整个序列有序
        for (int j = arr.length - 1; j > 0; j--) {
            temp = arr[j];
            arr[j] = arr[0];
            arr[0] = temp;
            adjustHeap(arr, 0, j);
        }

        System.out.println(Arrays.toString(arr));
    }

    /**
     * 将一个数组（二叉树）调整成一个颗大顶堆
     * 功能：完成将以i对应的非叶子节点的树调整成大顶堆
     * 举例 int[] arr = {4, 6, 8, 5, 9}; => i = 1 => adjustHeap => 得到 {4, 9, 8, 5 ,6}
     * 如果我们再次调用adjustHeap传入的是 i = 0 => 得到 {4, 9, 8, 5 ,6} => {9, 6, 8, 5, 4}
     *
     * @param arr    待调整的数组
     * @param i      表示非叶子节点在数组中索引
     * @param length 表示对多少个元素进行调整，length是在逐渐减少
     */
    public static void adjustHeap(int[] arr, int i, int length) {

        // 先取出当前元素的值，保存到临时变量
        int temp = arr[i];
        // 开始调整
        // 1. k = i * 2 + 1  k是i节点的左子节点
        for (int k = i * 2 + 1; k < length; k = k * 2 + 1) {
            // 说明左子节点的值小于右子节点的值
            if (k + 1 < length && arr[k] < arr[k + 1]) {
                // 指向右子节点
                k++;
            }
            // 如果节点大于父节点
            if (arr[k] > temp) {
                // 把较大的值赋值给当前节点
                arr[i] = arr[k];
                // i指向k，继续循环比较
                i = k;
            } else {
                break;
            }
        }
        // 当循环结束后，我们已经将以i，为父节点的树的最大值，放在了最底层(局部)
        arr[i] = temp;
    }


}
