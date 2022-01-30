package com.twelvet.hand.design.adapter;

import com.twelvet.hand.design.adapter.impl.Adapter;
import com.twelvet.hand.design.adapter.impl.NetworkCable;
import com.twelvet.hand.design.builder.Work;
import com.twelvet.hand.design.builder.pojo.Product;

/**
 * @author twelvet
 * @WebSite www.twelvet.cn
 * @Description: 测试类
 */
public class ConsumerTest {

    public static void main(String[] args) {
        // 电脑
        Computer computer = new Computer();
        // 网线
        NetworkCable networkCable = new NetworkCable();
        // 转换器
        Adapter adapter = new Adapter(networkCable);
        // 电脑通过转换器上网
        computer.net(adapter);

    }

}
