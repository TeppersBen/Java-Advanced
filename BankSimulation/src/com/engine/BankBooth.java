package com.engine;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Random;

import com.engine.entity.Banker;
import com.engine.entity.Customer;

public class BankBooth {

	private Banker banker;
	private Random random;
	
	private int queueSize;

	private boolean lockedDueLunchBreak;
	
	private boolean isBlocked;
	private boolean isClosed;
	
	private int density = 25000;
	
	private Deque<Customer> queue = new ArrayDeque<>();

	private Thread queueHandler = new Thread(() -> {
		while (true) {
			try {
				Thread.sleep(random.nextInt(getDensity()));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if (!isBlocked && !isClosed) {
				if (queue.size() <= getMaxQueueSize()) {
					Customer c = new Customer();
					queue.add(c);
					Logger.log("[BankBooth:] " + c.getFullName() + " has joined the queue @ " + getBanker().getFullName());
				}
			}
		}
	});
	
	public synchronized void forceDensity(int v) {
		density = v;
	}
	
	public synchronized void setDensity(int v) {
		density = 25000 - (v * (25000 / 11));
	}
	
	public synchronized int getDensity() {
		return density;
	}
	
	public synchronized Deque<Customer> getQueue() {
		return queue;
	}
	
	public BankBooth(int queueSize) {
		banker = new Banker(queue);
		random = new Random();
		this.queueSize = queueSize;
	}
	
	public boolean isAlive() {
		return banker.isAlive() && queueHandler.isAlive();
	}
	
	public synchronized void start() {
		banker.start();
		queueHandler.start();
	}
	
	public void join() {
		banker.join();
		try {
			queueHandler.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * prevents customers from joining the queue
	 * @param bool - true or false
	 */
	public synchronized void blockLine(boolean bool) {
		isBlocked = bool;
	}
	
	/**
	 * checks whether the line is blocked
	 * @return isBlocked
	 */
	public synchronized boolean isBlocked() {
		return isBlocked;
	}
	
	public Banker getBanker() {
		return banker;
	}

	public void setBanker(Banker banker) {
		this.banker = banker;
	}
	
	public synchronized boolean isLockedDueLunchBreak() {
		return lockedDueLunchBreak;
	}
	
	public synchronized boolean isAtLunchBreak() {
		if (isLockedDueLunchBreak() && queue.size() == 0)
			return true;
		return false;
	}
	
	public synchronized void setLockedDueLunchBreak(boolean bool) {
		lockedDueLunchBreak = bool;
	}
	
	public String toString() {
		String result = banker.getFullName() + " ";
		for (Customer c : queue) {
			result += c.getFullName() + " ";
		}
		return result;
	}
	
	public synchronized boolean hasBanker() {
		if (isClosed() && queue.size() == 0)
			return false;
		return true;
	}
	
	public synchronized boolean isClosed() {
		return isClosed;
	}
	
	public synchronized void setClosed(boolean bool) {
		isClosed = bool;
	}
	
	public synchronized int getMaxQueueSize() {
		return queueSize;
	}

	public Thread getThread() {
		return queueHandler;
	}

	public boolean isFull() {
		return getMaxQueueSize() == queue.size();
	}
	
}
