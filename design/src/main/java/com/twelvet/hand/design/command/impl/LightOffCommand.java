package com.twelvet.hand.design.command.impl;

import com.twelvet.hand.design.command.Command;
import com.twelvet.hand.design.command.LightReceiver;

public class LightOffCommand implements Command {
    //聚合LightReceiver
    LightReceiver lightReceiver;

    //构造器
    public LightOffCommand(LightReceiver lightReceiver) {
        this.lightReceiver = lightReceiver;
    }

    @Override
    public void execute() {
        //调用接收者的方法
        lightReceiver.off();
    }

    @Override
    public void undo() {
        //调用接收者的方法
        lightReceiver.on();
    }
}