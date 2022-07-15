package com.twelvet.hand.design.visitor.impl;

import com.twelvet.hand.design.visitor.Visitor;

public class Computer {

   // 此类作为 ObjectStructure，聚合了被访问者并使用
   private final Keyboard keyboard;

   private final Mouse mouse;

   public Computer(Keyboard keyboard, Mouse mouse) {
       this.keyboard = keyboard;
       this.mouse = mouse;
   }

   // 根据不同的访问者获取电脑的价格
   public double getPrice(Visitor visitor) {
       // 被访问者就收访问者
       return keyboard.accept(visitor) + mouse.accept(visitor);
   }

}