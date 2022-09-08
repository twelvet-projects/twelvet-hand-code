package com.twelvet.hand.problems;

import org.junit.Test;

/**
 * @author twelvet
 * @WebSite www.twelvet.cn
 * @Description: 二分查找
 * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
 */
public class 二分查找 {

    public static void main(String[] args) {
        int[] nums = {-1, 0, 3, 5, 9, 12};
        int target = 9;
        int search = search(nums, target);
        System.out.println(search);
    }

    public static int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            // (5 + 3) / 2
            int mid = (right + left) / 2;
            int num = nums[mid];
            if (num == target) {
                return mid;
            } else if (num > target) {
                // 在右边
                right = mid - 1;
            } else {
                // 在左边
                left = mid + 1;
            }
        }
        return -1;
    }
}
