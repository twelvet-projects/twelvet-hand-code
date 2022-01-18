package com.twelvet.hand.problems.sort;

import com.twelvet.hand.utils.$;
import org.junit.Test;

/**
 * @author twelvet
 * <p>
 * 排序算法
 */
public class SortPro {

    public static final int[] NUMBERS = {49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56, 17, 18, 23, 34, 15, 35, 25, 53, 51};

    /**
     * 直接插入排序
     */
    @Test
    public void shellSort() {
        $.startTimer();

        int temp;

        for (int i = 1; i < NUMBERS.length; i++) {
            int j = i - 1;
            temp = NUMBERS[i];
            for (; j >= 0 && temp < NUMBERS[j]; j--) {
                // 将大于temp的值整体后移一个单位
                NUMBERS[j + 1] = NUMBERS[j];
            }
            NUMBERS[j + 1] = temp;
        }

        $.fmtTimer();

        $.fmt(NUMBERS);
    }

    /**
     * 冒泡排序
     */
    @Test
    public void bubbleSort() {

        $.startTimer();

        int temp;

        for (int i = 0; i < NUMBERS.length - 1; i++) {

            for (int j = 0; j < NUMBERS.length - 1 - i; j++) {
                if (NUMBERS[j] > NUMBERS[j + 1]) {
                    temp = NUMBERS[j];
                    NUMBERS[j] = NUMBERS[j + 1];
                    NUMBERS[j + 1] = temp;
                }
            }

        }

        // 打印时间
        $.fmtTimer();

        $.fmt(NUMBERS);
    }


}
