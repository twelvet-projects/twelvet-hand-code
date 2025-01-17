package com.twelvet.hand.design.iterator;

import com.twelvet.hand.design.iterator.impl.NameRepository;

public class IteratorPatternDemo {

    public static void main(String[] args) {
        NameRepository namesRepository = new NameRepository();
        Iterator iter = namesRepository.getIterator();
        while (iter.hasNext()) {
            String name = (String) iter.next();
            System.out.println("Name : " + name);
        }
    }
}