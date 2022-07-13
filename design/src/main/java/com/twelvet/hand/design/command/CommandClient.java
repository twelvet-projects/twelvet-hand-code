package com.twelvet.hand.design.command;

import com.twelvet.hand.design.command.impl.LightOffCommand;
import com.twelvet.hand.design.command.impl.LightOnCommand;
import com.twelvet.hand.design.command.impl.RemoteController;

public class CommandClient {
    public static void main(String[] args) {
        //使用命令设计模式，完成通过遥控器，对电灯的控制

        //创建电灯的对象（接收者）
        LightReceiver lightReceiver = new LightReceiver();
        //创建电灯相关的开关命令
        LightOnCommand lightOnCommand = new LightOnCommand(lightReceiver);
        LightOffCommand lightOffCommand = new LightOffCommand(lightReceiver);

        //创建遥控器
        RemoteController remoteController = new RemoteController();
        //给遥控器设置相关的命令 比如 no=0是电灯的开关操作
        remoteController.setCommand(0, lightOnCommand, lightOffCommand);
        System.out.println("---按下电灯开的按钮---");
        remoteController.onButtonWasPushed(0);
        System.out.println("---按下电灯关的按钮---");
        remoteController.offButtonWasPushed(0);
        System.out.println("---撤销---");
        remoteController.undoButtonWasPushed();
    }
}