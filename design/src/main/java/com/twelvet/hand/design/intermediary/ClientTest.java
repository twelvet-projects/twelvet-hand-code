package com.twelvet.hand.design.intermediary;

import com.twelvet.hand.design.intermediary.impl.ConcreteColleague1;
import com.twelvet.hand.design.intermediary.impl.ConcreteColleague2;
import com.twelvet.hand.design.intermediary.impl.ConcreteMediator;

public class ClientTest {
    public static void main(String[] args) {
        ConcreteMediator mediator = new ConcreteMediator();

        ConcreteColleague1 colleague1 = new ConcreteColleague1(mediator);
        ConcreteColleague2 colleague2 = new ConcreteColleague2(mediator);

        mediator.setColleague1(colleague1);
        mediator.setColleague2(colleague2);

        colleague1.send("早上好啊！");
        colleague2.send("早安！");
    }
}