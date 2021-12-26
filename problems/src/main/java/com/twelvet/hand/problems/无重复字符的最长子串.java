package com.twelvet.hand.problems;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

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

        String str = "abbaaac";

        int n = str.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int end = 0, start = 0; end < n; end++) {
            // 返回指定下标位置char
            char alpha = str.charAt(end);
            // map是否存在此char
            if (map.containsKey(alpha)) {
                // 根据char获取储存最新value
                Integer integer = map.get(alpha);
                // 标记位置
                start = Math.max(integer, start);
            }
            //
            ans = Math.max(ans, end - start + 1);
            // 储存value，利用map唯一性
            map.put(alpha, end + 1);
        }
        System.out.println(ans);

    }

}
