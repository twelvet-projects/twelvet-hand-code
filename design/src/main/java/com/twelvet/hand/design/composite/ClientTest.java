package com.twelvet.hand.design.composite;

import com.twelvet.hand.design.composite.impl.Menu;
import com.twelvet.hand.design.composite.impl.MenuItem;

/**
 * @author twelvet
 * <p>
 */
public class ClientTest {

    public static void main(String[] args) {
        //创建根目录
        MenuComponent menuComponent = new Menu("根目录", 1);
        //添加两个子菜单项
        MenuComponent menu1 = new Menu("游戏", 2);
        menu1.add(new MenuItem("英雄联盟", 3));
        menu1.add(new MenuItem("地下城", 3));
        //将二级目录添加至根目录
        menuComponent.add(menu1);

        //创建二级目录
        MenuComponent menu2 = new Menu("办公", 2);
        menu2.add(new MenuItem("微信", 3));
        menu2.add(new MenuItem("QQ", 3));
        //将二级目录添加至根目录
        menuComponent.add(menu2);

        menuComponent.print();
    }
}
