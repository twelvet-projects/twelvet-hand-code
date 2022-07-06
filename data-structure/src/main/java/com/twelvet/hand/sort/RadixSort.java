package com.twelvet.hand.sort;

import java.util.Arrays;

/**
 * @author twelvet
 * @WebSite www.twelvet.cn
 * @Description: 、基数排序(从个位数开始排序，一直到最大位数，不够位数前方补零即可)
 */
public class RadixSort {

    public static void main(String[] args) {
        int[] arr = {53, 3, 542, 748, 14, 214};
        radixSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 基数排序
     *
     * @param arr 数组
     */
    public static void radixSort(int[] arr) {
        // 得到数组中最大的位数
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        int maxLength = (max + "").length();

        // 为了记录每个桶中，实际放了多少数据，我们定义一个一维数组记录每个桶的每次放入的数据个数
        // bucketElementCounts[0]，记录的就是bucket[0]桶的放入数据个数
        int[] bucketElementCounts = new int[10];

        for (int i = 0, n = 1; i < maxLength; i++, n *= 10) {
            // （针对每个元素的对应位数进行排序处理）,第一次个位，第二次十位，第三次百位

            // 定义一个二维数组，表示10个桶，每个桶就是一个一维数组
            // 1、二维数组包含10个一维数组
            // 2、为了防止放入数的时候，数据溢出，则每个一维数组，大小定位arr.length
            // 3、基数排序是使用空间换时间的经典算法
            int[][] bucket = new int[10][arr.length];

            for (int value : arr) {
                // 取出每个元素的个位数
                int digitOfElement = value / n % 10;
                // 放入对应的桶中
                bucket[digitOfElement][bucketElementCounts[digitOfElement]] = value;
                bucketElementCounts[digitOfElement]++;
            }
            // 按照这个桶的顺序（一维数组下标依次取出，放入原来数组）
            int index = 0;
            // 遍历每一桶，并将桶中是数据，放入到原数组
            for (int k = 0; k < bucketElementCounts.length; k++) {
                // 如果桶中，有数据，我们才放入到原数组
                if (bucketElementCounts[k] != 0) {
                    // 循环该桶第k个桶（第k个一维数组），放入
                    for (int l = 0; l < bucketElementCounts[k]; l++) {
                        arr[index++] = bucket[k][l];
                    }
                }
                // 使用完成需要归零
                bucketElementCounts[k] = 0;
            }
        }

    }

}
