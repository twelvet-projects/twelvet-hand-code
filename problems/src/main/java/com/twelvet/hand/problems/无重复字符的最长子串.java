package com.twelvet.hand.problems;

import org.junit.Test;

import java.util.HashMap;

/**
 * @author twelvet
 * @WebSite www.twelvet.cn
 * @Description: 无重复字符的最长子串
 * <p>
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 */
public class 无重复字符的最长子串 {

    @Test
    public void solution() {

        String str = "abba";

        HashMap<Character, Integer> map = new HashMap<>(16);
        // 最长子串长度
        int max = 0;
        // 滑动窗口左下标，right相当于滑动窗口右下标
        int left = 0;
        for (int right = 0; right < str.length(); right++) {
            // charAt() 方法用于返回指定索引处的字符。索引范围为从 0 到 length() - 1。
            char c = str.charAt(right);
            // map.get():返回字符所对应的索引，当发现重复元素时，窗口左指针右移至重复字符前一位
            if (map.containsKey(c)) {
                Integer value = map.get(c);
                left = Math.max(left, value + 1);
            }
            // map.get('a')=0,因为map中只有第一个a的下标，然后更新left指针到原来left的的下一位
            // 再更新map中a映射的下标
            map.put(str.charAt(right), right);
            // 比较两个参数的大小（取值最大的）
            max = Math.max(max, right - left + 1);
        }
        System.out.println(max);

    }

}
