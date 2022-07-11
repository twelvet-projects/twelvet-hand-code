package com.twelvet.hand.design.factory.factoryMethod.impl;

import com.twelvet.hand.design.factory.factoryMethod.Factory;
import com.twelvet.hand.design.factory.factoryMethod.Product;

/**
 * @author twelvet
 * <p>
 */
public class FactoryBImpl implements Factory {
    @Override
    public Product make() {
        return new ProductBImpl();
    }
}
