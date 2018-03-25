package com.engine;

import java.util.LinkedList;
import java.util.List;

public class Bank {
	
	private Clock clock;
	
	private boolean isOpen;
	private boolean isBreakTime;
	
	private List<BankBooth> booths;
	
	Thread t = new Thread(() -> {
		while (true) {
			aggressiveCheckOpen();
			process();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	});
	
	private void process() {
		if (isOpen && isBreakTime) {
			//prevent customers from joining the queue
			booths.forEach(e -> {
				if (!e.isBlocked()) {
					e.blockLine(true);
					e.setLockedDueLunchBreak(true);
				}
			});
			//Let the bankers finish their line and give them a break till 13:00:00
		}
		else if (isOpen && !isBreakTime) {
			//customers are able to join the queue
			//bankers have to work
			booths.forEach(e -> {
				if (e.isBlocked()) {
					e.blockLine(false);
					e.setLockedDueLunchBreak(false);
				}
				if (e.isClosed())
					e.setClosed(false);
			});
		}
		else if (!isOpen) {
			//no more customers are allowed to join the queue
			booths.forEach(e -> {
				if (!e.isBlocked())
					e.blockLine(true);
				if (!e.isClosed())
					e.setClosed(true);
			});
			//bankers finish their queues
		}
	}
	
	public Bank(Clock c) {
		this(c, 4);
	}
	
	public Bank(Clock c, int bankBooths) {
		this(c, bankBooths, 5);
	}
	
	public Bank(Clock c, int bankBooths, int queueLength) {
		clock = c;
		booths = new LinkedList<>();
		for (int i = 0; i < bankBooths; i++) {
			booths.add(new BankBooth(queueLength));
		}
		aggressiveCheckOpen();
		booths.forEach(e -> {
			e.start();
		});
		t.start();
	}
	
	/**
	 * aggressive way to figure out what stage we are of the day
	 */
	private void aggressiveCheckOpen() {
		int value = Integer.parseInt(clock.toString().split(":")[0]);
		if (value <= 7) {
			isOpen = false;
			isBreakTime = false;
			booths.forEach(e -> {
				e.setClosed(true);
			});
		} else if (value >= 8 && value <= 11) {
			isOpen = true;
			isBreakTime = false;
		} else if (value == 12) {
			isOpen = true;
			isBreakTime = true;
		} else if (value >= 13 && value < 18) {
			isOpen = true;
			isBreakTime = false;
		} else if (value >= 18) {
			isOpen = false;
			isBreakTime = false;
			booths.forEach(e -> {
				e.setClosed(true);
			});
		}
	}
	
	public synchronized void setOpen(boolean bool) {
		isOpen = bool;
	}

	public synchronized void setClock(Clock c) {
		clock = c;
	}
	
	public synchronized Clock getClock() {
		return clock;
	}
	
	public List<BankBooth> getBankBooths() {
		return booths;
	}
}