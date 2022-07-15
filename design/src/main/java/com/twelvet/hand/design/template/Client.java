package com.twelvet.hand.design.template;

import com.twelvet.hand.design.template.impl.ConcreteClass1;
import com.twelvet.hand.design.template.impl.ConcreteClass2;

public class Client {

    public static void main(String[] args) {
        ConcreteClass1 class1 = new ConcreteClass1();
        AbstractClass class2 = new ConcreteClass2();

        // 子类新增方法
        class1.setIsDoAnything(false);

        class1.templateMethod(); //输出this代表的对象
        System.out.println(class1.toString());
        class2.templateMethod(); //输出this代表的对象
        System.out.println(class2.toString());

    }
}