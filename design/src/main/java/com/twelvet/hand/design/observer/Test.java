package com.twelvet.hand.design.observer;

import com.twelvet.hand.design.observer.impl.Clown;
import com.twelvet.hand.design.observer.impl.Viewer;

public class Test {

    public static void main(String[] args) {
        Clown c = new Clown();

        for (int i = 1; i < 4; i++) {
            Viewer v = new Viewer(i);
            c.addObserver(v);
            System.out.println(v.getId() + "号观众入席");
        }

        c.perform();
        c.exit();
    }

}