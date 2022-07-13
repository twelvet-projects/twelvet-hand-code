package com.twelvet.hand.design.command.impl;

import com.twelvet.hand.design.command.Command;
import com.twelvet.hand.design.command.impl.NoCommand;

public class RemoteController {
    //开关按钮的命令数组
    Command[] onCommands;
    Command[] offCommands;
    //执行撤销按钮操作
    Command undoCommand;

    //构造器，完成对按钮的初始化
    public RemoteController() {
        onCommands = new Command[5];
        offCommands = new Command[5];
        for (int i = 0; i < 5; i++) {
            onCommands[i] = new NoCommand();
            offCommands[i] = new NoCommand();
        }
    }

    //给我们的按钮设置你需要的命令即可
    public void setCommand(int no, Command onCommand, Command offCommand) {
        onCommands[no] = onCommand;
        offCommands[no] = offCommand;
    }

    //按下开按钮
    public void onButtonWasPushed(int no) {
        onCommands[no].execute();
        //记录这次操作，用于撤销
        undoCommand = onCommands[no];
    }

    public void offButtonWasPushed(int no) {
        offCommands[no].execute();
        undoCommand = offCommands[no];
    }

    //撤销
    public void undoButtonWasPushed() {
        undoCommand.undo();
    }
}