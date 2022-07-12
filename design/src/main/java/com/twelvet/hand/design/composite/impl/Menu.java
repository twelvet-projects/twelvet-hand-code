package com.twelvet.hand.design.composite.impl;

import com.twelvet.hand.design.composite.MenuComponent;

import java.util.ArrayList;
import java.util.List;

/**
 * 树枝节点
 */
public class Menu extends MenuComponent {

    //存储菜单或者菜单项
    private final List<MenuComponent> menuComponentList = new ArrayList<>();

    public Menu(String name, int level) {
        this.name = name;
        this.level = level;
    }

    @Override
    public void add(MenuComponent menuComponent) {
        menuComponentList.add(menuComponent);
    }

    @Override
    public void remove(MenuComponent menuComponent) {
        menuComponentList.remove(menuComponent);
    }

    @Override
    public MenuComponent getChild(int index) {
        return menuComponentList.get(index);
    }

    @Override
    public void print() {
        //打印菜单名称
        for (int i = 0; i < level; i++) {
            System.out.print("-");
        }
        System.out.println(name);
        for (MenuComponent component : menuComponentList) {
            component.print();
        }
    }
}
