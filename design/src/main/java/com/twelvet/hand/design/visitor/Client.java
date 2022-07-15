package com.twelvet.hand.design.visitor;

import com.twelvet.hand.design.visitor.impl.*;

public class Client {
    public static void main(String[] args) {
        // 创建鼠标键盘和电脑
        Keyboard keyboard = new Keyboard("keyboard", 100d);
        Mouse mouse = new Mouse("mouse", 100d);
        Computer computer = new Computer(keyboard, mouse);
        // 使用不同的访问者获取电脑的价格
        PersonVisitor personVisitor = new PersonVisitor();
        System.out.println("个人获得的电脑价格是：" + computer.getPrice(personVisitor));

        GroupVisitor groupVisitor = new GroupVisitor();
        System.out.println("群体获得的电脑价格是：" + computer.getPrice(groupVisitor));

        // 如果还有其他的访问者，直接增加其实现类即可，不用改动其他代码，被访问者就可以做出不同的响应
    }
}
