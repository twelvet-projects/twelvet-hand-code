package com.twelvet.hand.array.stack;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author twelvet
 * <p>
 * 栈实现计算器
 */
public class Calculator {

    private static final Logger log = LoggerFactory.getLogger(Calculator.class);

    public static void main(String[] args) {
        String expression = "3+2*6-100";

        // 创建两个栈，数栈，
        ArrayStackCalculator stackNum = new ArrayStackCalculator(10);
        // 运算符号栈
        ArrayStackCalculator stackOper = new ArrayStackCalculator(10);
        // 定义需要的相关变量
        // 用于扫描
        int index = 0;
        int num1 = 0;
        int num2 = 0;
        int oper = 0;
        int res = 0;
        // 将每次扫描得到的char保存
        char ch = ' ';
        String keepNum = "";
        do {
            // 得到字符串中的字符
            ch = expression.substring(index, index + 1).charAt(0);
            // 判断是数字还是运算符
            if (stackOper.isOper(ch)) {
                // 判断当前符号栈是否为空
                if (!stackOper.isEmpty()) {
                    /**
                     * 如果符号站有操作符就进行比较，如果当前操作符优先级小于或者等于操作符号，就需要从数栈中pop出两个数进行运算
                     * 将得到的结果入数栈，然后将当前的操作符号入栈
                     */
                    if (stackOper.priority(ch) <= stackOper.priority(stackOper.peek())) {
                        num1 = stackNum.pop();
                        num2 = stackNum.pop();
                        oper = stackOper.pop();
                        res = stackNum.cal(num1, num2, oper);
                        // 把运算的结果入栈
                        stackNum.push(res);
                        // 然后把当前的操作符入栈
                        stackOper.push(ch);
                    } else {
                        // 如果当前的操作符优先级大于栈中的操作符，就直接入符号站
                        stackOper.push(ch);
                    }
                } else {
                    // 如果为空直接入栈
                    stackOper.push(ch);
                }
            } else {
                // 如果是数栈，则直接入数栈
                //stackNum.push(ch - 48);
                // 在处理多位数时，不能发现是一个数就立即入栈，因为可能是多位数
                keepNum += ch;
                // 如果ch已经是expression最后一位，就直接入栈
                if (index == expression.length() - 1) {
                    stackNum.push(Integer.parseInt(keepNum));
                } else {
                    char c = expression.substring(index + 1, index + 2).charAt(0);
                    if (stackOper.isOper(c)) {
                        stackNum.push(Integer.parseInt(keepNum));
                        keepNum = "";
                    }
                }
            }
            // 让index + 1，并判断是否扫描到最后
            index++;
        } while (index < expression.length());

        // 当表达式扫描完成,就顺序从数栈拿出响应的数和符号，并运算
        while (!stackOper.isEmpty()) {
            // 如果符号为空，则计算到最后的结果
            num1 = stackNum.pop();
            num2 = stackNum.pop();
            oper = stackOper.pop();
            res = stackNum.cal(num1, num2, oper);
            stackNum.push(res);
        }
        log.info("表达式：{} = {}", expression, stackNum.pop());
    }

}


class ArrayStackCalculator {

    private static final Logger log = LoggerFactory.getLogger(ArrayStack.class);

    /**
     * 栈的大小
     */
    private final int maxSize;

    /**
     * 数组，数组模拟栈
     */
    private final int[] stack;

    /**
     * 栈初始化为-1
     */
    private int top = -1;

    /**
     * 构造器设置数据初始化
     *
     * @param maxSize 堆栈大小
     */
    public ArrayStackCalculator(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
    }

    /**
     * 查看栈顶的数值，不会出栈
     *
     * @return int
     */
    public int peek() {
        return stack[top];
    }

    /**
     * 判断栈是否满
     *
     * @return true||false
     */
    public boolean isFull() {
        // 当最大减1代表满了
        return top == maxSize - 1;
    }

    /**
     * 判断栈是否为空
     *
     * @return true||false
     */
    public boolean isEmpty() {
        return top == -1;
    }

    /**
     * 入栈
     *
     * @param value 入堆栈数据
     */
    public void push(int value) {
        if (isFull()) {
            log.error("堆栈已满，无法添加");
        }
        top++;
        stack[top] = value;
    }

    /**
     * 出堆栈，返回顶部数据
     *
     * @return 返回数据
     */
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("栈空，没有数据");
        }
        int value = stack[top];
        top--;
        return value;
    }

    /**
     * 显示栈，遍历时需要从栈顶开始显示数据
     */
    public void list() {
        if (isEmpty()) {
            throw new RuntimeException("栈空，没有数据");
        }
        for (int i = top; i >= 0; i--) {
            log.info("stack[{}]：{}", i, stack[i]);
        }
    }

    /**
     * 返回运算符的优先级，优先级使用数字表示，约大优先级越高
     *
     * @param oper 计算符号
     * @return 优先级代表符号
     */
    public int priority(int oper) {
        if (oper == '*' || oper == '/') {
            return 1;
        } else if (oper == '+' || oper == '-') {
            return 0;
        } else {
            // 目前只有+ - * /
            return -1;
        }
    }

    /**
     * 判断是否为操作符
     *
     * @param val val
     * @return true||false
     */
    public boolean isOper(int val) {
        return val == '+' || val == '-' || val == '*' || val == '/';
    }

    /**
     * 计算方法
     *
     * @param num1 num
     * @param num2 num
     * @param oper 操作符
     * @return 计算结果
     */
    public int cal(int num1, int num2, int oper) {
        switch (oper) {
            case '+':
                return num2 + num1;
            case '-':
                return num2 - num1;
            case '*':
                return num2 * num1;
            case '/':
                return num2 / num1;
            default:
                return 0;
        }
    }

}