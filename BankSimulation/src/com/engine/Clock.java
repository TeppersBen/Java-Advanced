package com.engine;

public class Clock implements Runnable {

	private int clockSpeed;
	
	private int seconds;
	private int minutes;
	private int hours;
	
	private Thread thread = new Thread(this);
	
	public Clock() {
		this(7, 59, 55);
	}
	
	public Clock(int hours, int minutes, int seconds) {
		fixTime(hours, minutes, seconds);
		clockSpeed = 1000;
		start();
	}
	
	private void fixTime(int hours, int minutes, int seconds) {
		minutes += seconds / 60;
		seconds %= 60;
		hours += minutes / 60;
		minutes %= 60;
		hours %= 24;
		this.hours = hours;
		this.minutes = minutes;
		this.seconds = seconds;
	}
	
	public String toString() {
		return String.format("%02d:%02d:%02d", hours, minutes, seconds);
	}

	public synchronized void start() {
		thread.start();
	}
	
	public void join() {
		try {
			thread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public synchronized void setClockSpeed(int v) {
		clockSpeed = 1000 / ((v == 0) ? 1 : v);
	}
	
	public synchronized int getClockSpeed() {
		return clockSpeed;
	}
	
	@Override
	public void run() {
		while (true) {
			seconds++;
			fixTime(hours, minutes, seconds);
			try {
				Thread.sleep(getClockSpeed());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}