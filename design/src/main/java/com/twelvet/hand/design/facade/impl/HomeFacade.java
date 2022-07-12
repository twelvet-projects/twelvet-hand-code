package com.twelvet.hand.design.facade.impl;

public class HomeFacade {
    // 定义各个子系统对象
    private final Popcorn popcorn;
    private final Stereo stereo;
    private final Screen screen;
    private final Projector projector;
    private final DVDPlayer dvdPlayer;

    public HomeFacade() {
        this.popcorn = Popcorn.getInstance();
        this.stereo = Stereo.getInstance();
        this.screen = Screen.getInstance();
        this.projector = Projector.getInstance();
        this.dvdPlayer = DVDPlayer.getInstance();
    }

    public void ready() {
        popcorn.on();
        popcorn.pop();
        screen.down();
        projector.on();
        stereo.on();
        dvdPlayer.on();
    }

    public void play() {
        dvdPlayer.play();
    }

    public void pause() {
        dvdPlayer.pause();
    }

    public void end() {
        popcorn.off();
        screen.up();
        projector.off();
        stereo.off();
        dvdPlayer.off();
    }
}