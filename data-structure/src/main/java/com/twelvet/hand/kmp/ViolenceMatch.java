package com.twelvet.hand.kmp;

/**
 * @author twelvet
 * <p>
 * 暴力匹配算法
 */
public class ViolenceMatch {
    public static void main(String[] args) {
        String str1 = "twelvet twelvet twelvet";
        String str2 = "elvet";
        int i = violenceMath(str1, str2);
        System.out.println("index = " + i);
    }

    // 暴力匹配算法实现
    public static int violenceMath(String str1, String str2) {
        char[] s1 = str1.toCharArray();
        char[] s2 = str2.toCharArray();

        int s1Len = s1.length;
        int s2Len = s2.length;

        int i = 0; // i索引指向s1
        int j = 0; // j索引指向s2
        while (i < s1Len && j < s2Len) {
            if (s1[i] == s2[j]) {
                i++;
                j++;
            } else { // 没有匹配成功
                // 如果失败，即str1[i] != str2[j], 令i = i - (j - 1), j = 0
                i = i - (j - 1);
                j = 0;
            }
        }

        if (j == s2Len) {
            return i - j;
        } else {
            return -1;
        }

    }
}
