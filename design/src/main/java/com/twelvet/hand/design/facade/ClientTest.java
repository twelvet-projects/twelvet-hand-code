package com.twelvet.hand.design.facade;

import com.twelvet.hand.design.facade.impl.HomeFacade;

/**
 * 客户端
 */
public class ClientTest {
    public static void main(String[] args) {
        // 门面类
        HomeFacade homeFacade = new HomeFacade();
        // 打开所有家电
        homeFacade.ready();
        System.out.println("=====================");
        // 播放
        homeFacade.play();
        System.out.println("=====================");
        // 暂停
        homeFacade.pause();
        System.out.println("=====================");

        // 关机
        homeFacade.end();

    }
}