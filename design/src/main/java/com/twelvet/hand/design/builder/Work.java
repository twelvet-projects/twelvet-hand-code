package com.twelvet.hand.design.builder;

import com.twelvet.hand.design.builder.pojo.Product;

/**
 * @author twelvet
 * @WebSite www.twelvet.cn
 * @Description: 工作者
 */
public class Work extends Builder {

    private Product product;

    public Work() {
        product = new Product();
    }

    @Override
    Builder phone(String msg) {
        product.setPhone(msg);
        return this;
    }

    @Override
    Builder computer(String msg) {
        product.setComputer(msg);
        return this;
    }

    @Override
    Builder router(String msg) {
        product.setRouter(msg);
        return this;
    }

    @Override
    Builder watch(String msg) {
        product.setWatch(msg);
        return this;
    }

    @Override
    Product getProduct() {
        return product;
    }

}
