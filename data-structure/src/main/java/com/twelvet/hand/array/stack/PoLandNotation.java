package com.twelvet.hand.array.stack;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @author twelvet
 * @WebSite www.twelvet.cn
 * @Description: 、逆波兰表达式
 */
public class PoLandNotation {

    private static final Logger log = LoggerFactory.getLogger(PoLandNotation.class);

    public static void main(String[] args) {
        // 说明为了方便逆波兰表达式的数字和符号使用空格隔开
        String subffixexpression = "3 4 + 5 * 6 -";
        // 先将3 4 + 5 x 6 -放到list中
        // 将list传递给一个方法，遍历list配合栈完成计算
        List<String> rpnList = getLIstString(subffixexpression);
        int calculate = calculate(rpnList);
        log.info("计算结果为：{}", calculate);
    }

    /**
     * 将一个逆波兰表达式，依次将数据和运算符放到list中
     *
     * @param subffixexpression 逆波兰表达式
     * @return List<String>
     */
    public static List<String> getLIstString(String subffixexpression) {
        // 将subffixexpression分割
        String[] split = subffixexpression.split(" ");
        List<String> list = new ArrayList<String>(Arrays.asList(split));
        return list;
    }

    /**
     * 完成逆波兰表达式运算
     *
     * @param ls 表达式数组
     */
    public static int calculate(List<String> ls) {
        Stack<String> stack = new Stack<>();
        for (String item : ls) {
            // 这里使用正则表达式来取出数
            if (item.matches("\\d+")) {
                // 匹配多位数
                stack.push(item);
            } else {
                // pop出两个数，并运算
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());
                int res = 0;
                switch (item) {
                    case "+":
                        res = num1 + num2;
                        break;
                    case "-":
                        res = num1 - num2;
                        break;
                    case "*":
                        res = num1 * num2;
                        break;
                    case "/":
                        res = num1 / num2;
                        break;
                    default:
                        throw new RuntimeException("运算符错误");
                }
                // 把结果入栈
                stack.push(String.valueOf(res));

            }
        }
        // 最后留在stack中的数据是运算结果
        return Integer.parseInt(stack.pop());
    }

}
