package com.twelvet.hand.problems;

/**
 * @author twelvet
 * @WebSite www.twelvet.cn
 * @Description: 猜数字大小
 * 猜数字游戏的规则如下：
 * <p>
 * 每轮游戏，我都会从 1 到 n 随机选择一个数字。 请你猜选出的是哪个数字。
 * 如果你猜错了，我会告诉你，你猜测的数字比我选出的数字是大了还是小了。
 * <p>
 * 你可以通过调用一个预先定义好的接口 int guess(int num) 来获取猜测结果，返回值一共有 3 种可能的情况（-1，1 或 0）：
 * <p>
 * -1：我选出的数字比你猜的数字小 pick < num
 * 1：我选出的数字比你猜的数字大 pick > num
 * 0：我选出的数字和你猜的数字一样。恭喜！你猜对了！pick == num
 * <p>
 * 返回我选出的数字。
 */
public class 猜数字大小 extends GuessGame {

    public static void main(String[] args) {
        int search = guessNumber(15);
        System.out.println(search);
    }

    public static int guessNumber(int n) {
        int left = 0, right = n;
        while (left < right) {
            // 防止计算时溢出
            int mid = left + (right - left) / 2;
            if (guess(mid) <= 0) {
                // 答案在区间 [left, mid] 中
                right = mid;
            } else {
                // 答案在区间 [mid+1, right] 中
                left = mid + 1;
            }
        }
        // 此时有 left == right，区间缩为一个点，即为答案
        return left;
    }


}

class GuessGame {
    public static int guess(int mid) {
        int res = 9;
        if (res == mid) {
            return 0;
        }
        return res > mid ? 1 : -1;
    }
}
