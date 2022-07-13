package com.twelvet.hand.design.command.impl;

import com.twelvet.hand.design.command.Command;

public class NoCommand implements Command {
    @Override
    public void execute() {
        System.out.println("空命令");
    }

    @Override
    public void undo() {
        System.out.println("空命令");
    }
}