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
 * @Description: 逆波兰表达式
 */
public class PoLandNotation {

    private static final Logger log = LoggerFactory.getLogger(PoLandNotation.class);

    public static void main(String[] args) {
        /*// 说明为了方便逆波兰表达式的数字和符号使用空格隔开
        String subffixexpression = "3 4 + 5 * 6 -";
        // 先将3 4 + 5 x 6 -放到list中
        // 将list传递给一个方法，遍历list配合栈完成计算
        List<String> rpnList = getLIstString(subffixexpression);
        int calculate = calculate(rpnList);
        log.info("计算结果为：{}", calculate);*/

        String expression = "1+((2+3)*4)-5";
        // 将字符串转数组
        List<String> infixExpreessionList = toInfixExpressionList(expression);
        log.info("中缀表达式对应的list: {}", infixExpreessionList);
        List<String> subffixExpreesionList = paresSubffixExpreesion(infixExpreessionList);
        log.info("后缀表达式对应的list：{}", subffixExpreesionList);
        log.info("计算结果：{}", calculate(subffixExpreesionList));
    }

    /**
     * 将中缀表达式转换后缀表达式
     *
     * @return List<String>
     */
    public static List<String> paresSubffixExpreesion(List<String> ls) {
        // 符号栈
        Stack<String> s1 = new Stack<>();
        // 因为s2这个栈，在整个转换的过程中，没有pop操作，而且后面还要逆序输出
        // 因此比较麻烦，这里我们就不用Stack<String> 直接使用List<String> s2
        // Stack<String> s2 = new Stack<String>
        // 直接使用list
        List<String> s2 = new ArrayList<>();
        for (String item : ls) {
            // 如果是一个数字，加入s2
            if (item.matches("\\d+")) {
                s2.add(item);
            } else if (item.equals("(")) {
                s1.push(item);
            } else if (item.equals(")")) {
                // 如果是右括号")" 则依次弹出s1栈顶的运算符，并压入s2，直到遇到左括号为止，此时丢次这对()
                while (!s1.peek().equals("(")) {
                    s2.add(s1.pop());
                }
                // 将(弹出s1
                s1.pop();
            } else {
                // 档item的优先级小于等于s1栈定运算符，将s1栈顶的运算符弹出并加入到s2，再次转到与s1中新的栈顶运算符相比较
                while (s1.size() != 0 && Operation.getValue(s1.peek()) >= Operation.getValue(item)) {
                    s2.add(s1.pop());
                }
                // 还需要将item压入栈
                s1.push(item);
            }
        }
        while (s1.size() != 0) {
            s2.add(s1.pop());
        }
        // 因为是list，因此按顺序输出就是逆波兰表达式
        return s2;
    }

    /**
     * 将中缀表但是转成对应list
     *
     * @param s 表达式
     * @return 表达式数组
     */
    public static List<String> toInfixExpressionList(String s) {
        List<String> ls = new ArrayList<>();
        int i = 0;
        StringBuilder str;
        char c;
        do {
            if ((c = s.charAt(i)) < 48 || (c = s.charAt(i)) > 57) {
                ls.add(String.valueOf(c));
                i++;
            } else {
                // 如果是一个数字，需要考虑多位数
                str = new StringBuilder();
                // 先将str置空 '0'[48] -> '9'[57]
                while (i < s.length() && (c = s.charAt(i)) >= 48 && (c = s.charAt(i)) <= 57) {
                    str.append(c);
                    i++;
                }
                ls.add(str.toString());
            }
        } while (i < s.length());
        return ls;
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
        return new ArrayList<String>(Arrays.asList(split));
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

/**
 * 返回一个运算符对应的优先级
 */
class Operation {

    private static final Logger log = LoggerFactory.getLogger(Operation.class);

    private static int ADD = 1;
    private static int SUB = 1;
    private static int MUL = 1;
    private static int DIV = 1;

    public static int getValue(String operation) {
        switch (operation) {
            case "+":
                return ADD;
            case "-":
                return SUB;
            case "*":
                return MUL;
            case "/":
                return DIV;
            default:
                log.error("不存在该运算符");
                break;
        }
        return 0;
    }

}
