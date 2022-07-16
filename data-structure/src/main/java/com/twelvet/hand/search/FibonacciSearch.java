package com.twelvet.hand.search;

import java.util.Arrays;

/**
 * @author twelvet
 * @WebSite www.twelvet.cn
 * @Description: 、斐波那契算法（黄金分割法）
 */
public class FibonacciSearch {

    public static int maxSize = 20;

    public static void main(String[] args) {
        int[] arr = {1, 8, 10, 1000, 1234};

        System.out.println(fibSearch(arr, 1));
    }

    /**
     * 因为后面我们mid=low+F(k - 1) - 1，需要使用到斐波那契，因此我们需要获取到一个斐波那契数列
     * 非递归方法得到一个斐波那契数列
     *
     * @return
     */
    public static int[] fib() {
        int[] f = new int[maxSize];
        f[0] = 1;
        f[1] = 1;
        for (int i = 2; i < maxSize; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        return f;
    }

    /**
     * 斐波那契算法
     *
     * @param a   数组
     * @param key 我们需要查找的关键码（键）
     * @return 返回对应的下标，如果没有-1
     */
    public static int fibSearch(int[] a, int key) {
        int low = 0;
        int high = a.length - 1;
        // 表示斐波那契分割数值下标
        int k = 0;
        // 存放mid值
        int mid = 0;
        // 获取到斐波那契分割数组值的下标
        int f[] = fib();
        while (high > f[k] - 1) {
            k++;
        }
        // 因为f【k】值可能大于a的长度，因此我们需要使用Arrays类，构造一个新的数组，并指向a【】
        int[] temp = Arrays.copyOf(a, f[k]);
        // 实际上需求使用a数组最后的数组填充temp
        // temp = {1, 8, 10, 1000, 1234, 0, 0} => {, 8, 10, 1000, 1234, 1234, 1234}
        for (int i = high + 1; i < temp.length; i++) {
            temp[i] = a[high];
        }

        // 使用while循环，找到我们的数key
        while (low <= high) {
            // 只要这个条件满足，就可以找
            mid = low + f[k - 1] - 1;
            if (key < temp[mid]) {
                // 我们应该继续向数组的前面查找(左边)
                high = mid - 1;

                // 为甚是k--
                // 说明
                // 1. 全部元素 = 前面的元素 + 后边元素
                // 2. f[k] = f[k -1] + f[k -2]
                // 因为前面有f[k - 1]个元素，所以可以继续拆分k[k - 2] + f[k - 3]
                // 即在f[k-1] 的前面继续查找
                k--;
            } else if (key > temp[mid]) {
                // 我们应该继续向数组的后面查找(右边)
                low = mid + 1;
                k -= 2;
            } else {
                return Math.min(mid, high);
            }
        }
        return -1;
    }

}
