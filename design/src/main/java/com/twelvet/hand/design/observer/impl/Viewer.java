package com.twelvet.hand.design.observer.impl;

import java.util.Observable;
import java.util.Observer;

//观众类
public class Viewer implements Observer {
	private int id;
 
	
	public Viewer(int id) {
		super();
		this.id = id;
	}
 
 
	public int getId() {
		return id;
	}
 
 
	public void setId(int id) {
		this.id = id;
	}
 
 
	@Override
	public void update(Observable o, Object arg) {
		Integer state=(Integer) arg;
		switch(state) {
			case Clown.good:
				applause();
				break;
			case Clown.bad:
				cheerback();
				break;
			case Clown.complete:
				exit();
				break;
		}
	}
	
	private void applause() {
		System.out.println(id+"号观众鼓掌了");
	}
	
	private void cheerback() {
		System.out.println(id+"号观众喝倒彩");
	}
	
	private void exit() {
		System.out.println(id+"号观众退场了");
	}
 
}