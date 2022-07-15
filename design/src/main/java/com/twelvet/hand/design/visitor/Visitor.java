package com.twelvet.hand.design.visitor;

import com.twelvet.hand.design.visitor.impl.Keyboard;
import com.twelvet.hand.design.visitor.impl.Mouse;

public interface Visitor {

   // 访问者抽象父接口 其中的访问回调方法(参数为具体的被访问者)需要包含所有的访问者实现
   // 所以这就要求了被访问的子类是固定的，如果不固定，增加或者删除，就要修改Visitor类中方法数量

   // 访问Keyboard的访问回调 这样不同的访问者访问同一个被访问者得到的结果都不同
   double visitKeyboard(Keyboard keyboard);

   // 访问Mouse的访问回调
   double visitMouse(Mouse mouse);

}

