package com.twelvet.hand.design.command.impl;

import com.twelvet.hand.design.command.Command;
import com.twelvet.hand.design.command.LightReceiver;

public class LightOnCommand implements Command {

    //聚合LightReceiver
    LightReceiver lightReceiver;

    //构造器
    public LightOnCommand(LightReceiver lightReceiver) {
        this.lightReceiver = lightReceiver;
    }

    @Override
    public void execute() {
        //调用接收者的方法
        lightReceiver.on();
    }

    @Override
    public void undo() {
        //调用接收者的方法
        lightReceiver.off();
    }
}