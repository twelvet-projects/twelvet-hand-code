package com.twelvet.hand.design.command;

public interface Command {
    //执行动作
    void execute();

    //撤销动作
    void undo();
}