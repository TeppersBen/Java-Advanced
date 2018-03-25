package com.engine.entity;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Random;

import com.engine.Logger;

public class Banker extends Entity implements Runnable {

	private Thread thread = new Thread(this);
	
	private Deque<Customer> queue = new ArrayDeque<>();
	
	private boolean isHelping;
	
	private Stats stats;
	
	private Customer customer;
	private Random random;
	
	public Banker(Deque<Customer> queue) {
		super();
		this.queue = queue;
		random = new Random();
		stats = new Stats();
	}
	
	@Override
	public void run() {
		while (true) {
			if (!isHelping) {
				customer = queue.peekFirst();
				if (customer != null)
					isHelping = true;
			}
			if (isHelping) {
				Logger.log("[Banker:] " + getFullName() + " is serving " + customer.getFullName());
				try {
					Thread.sleep(random.nextInt(10000) + 2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				queue.pollFirst();
				Logger.log("[Banker:] " + getFullName() + " has served " + customer.getFullName());
				getStats().servedPerson();
				isHelping = false;
			}
			try {
				Thread.sleep(random.nextInt(5000));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public synchronized boolean isHelping() {
		return isHelping;
	}

	public synchronized void start() {
		thread.start();
	}
	
	public boolean isAlive() {
		return thread.isAlive();
	}

	public void join() {
		try {
			thread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Stats getStats() {
		return stats;
	}

}