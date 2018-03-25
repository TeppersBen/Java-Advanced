package com.engine.entity;

public class Stats {

	private int served; //How many people have been server
	
	public synchronized void servedPerson() {
		served++;
	}
	
	public synchronized int getServedPeople() {
		return served;
	}
	
}