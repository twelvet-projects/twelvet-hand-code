package com.twelvet.hand.problems;

import com.twelvet.hand.utils.$;
import org.junit.Test;

/**
 * @author twelvet
 * <p>
 * 两数之和
 * <p>
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * <p>
 * 你可以按任意顺序返回答案
 */
public class 两数之和 {

    @Test
    public void solution() {
        int[] nums = {1,2,2,9,5,6};
        int[] ints = twoSum(nums, 10);

        $.fmt(ints);
    }

    /**
     * @param nums   数组
     * @param target 相加数字
     * @return 数组下标
     */
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }

}
