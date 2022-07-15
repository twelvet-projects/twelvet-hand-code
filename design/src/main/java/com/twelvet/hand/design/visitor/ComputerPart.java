package com.twelvet.hand.design.visitor;

public abstract class ComputerPart {

   // 电脑组件抽象父类 也就是被访问者 提供接收访问者方法

   protected String name;

   public double price;

   public ComputerPart(String name, double price) {
       this.name = name;
       this.price = price;
   }

   // 接收访问者，双分派中第一次分派
   public abstract double accept(Visitor visitor);

}

