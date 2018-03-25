package com.presentation;

import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import com.engine.Bank;
import com.engine.Clock;

public class DebugSession{

	private Frame frame;
	private Bank bank;
	
	public DebugSession(Setup setup) {
		JMenuBar mainBar = new JMenuBar();
		JMenu menu = new JMenu("Launch");
		JMenuItem debugLaunch = new JMenuItem("Debug", new ImageIcon(getClass().getResource("/com/resources/icons/debug.png")));
		menu.add(debugLaunch);
		JMenuItem stressTestLaunch = new JMenuItem("StressTest", new ImageIcon(getClass().getResource("/com/resources/icons/stressTest.png")));
		menu.add(stressTestLaunch);
		JMenuItem defaultLaunch = new JMenuItem("Start (Default)", new ImageIcon(getClass().getResource("/com/resources/icons/start.png")));
		menu.add(defaultLaunch);
		menu.addSeparator();
		JMenuItem exitApp = new JMenuItem("Exit", new ImageIcon(getClass().getResource("/com/resources/icons/exit.png")));
		menu.add(exitApp);
		mainBar.add(menu);
		setup.setJMenuBar(mainBar);
		
		debugLaunch.addActionListener(e->{
			bank = new Bank(new Clock(7, 59, 55), 40, 5);
			frame = new Frame(bank);
			frame.getBankBooths().setColors(setup.getColorWaiting().getColor(), 
											setup.getColorServing().getColor(), 
											setup.getColorFullQueue().getColor(),
											setup.getColorLunchBreak().getColor(),
											setup.getColorClosed().getColor(),
											setup.getColorThreadFailure().getColor());
			frame.getBankBooths().setColoredMode(true);
			frame.getTabbedPane().setEnabledAt(2, false);
			frame.setTitle("Bank Simulation - DEBUG MODE");
			setup.dispose();
			getSession(30005).start();
		});
		
		stressTestLaunch.addActionListener(e->{
			bank = new Bank(new Clock(7, 59, 55), 40, 5);
			frame = new Frame(bank);
			frame.getBankBooths().setColors(setup.getColorWaiting().getColor(), 
											setup.getColorServing().getColor(), 
											setup.getColorFullQueue().getColor(),
											setup.getColorLunchBreak().getColor(),
											setup.getColorClosed().getColor(),
											setup.getColorThreadFailure().getColor());
			frame.getBankBooths().setColoredMode(true);
			frame.getTabbedPane().setEnabledAt(2, false);
			bank.getBankBooths().forEach(x->{ x.forceDensity(2500); });
			frame.setTitle("Bank Simulation - STRESS TEST");
			setup.dispose();
			getSession(60005).start();
		});
		
		defaultLaunch.addActionListener(e->{
			bank = new Bank(new Clock(7, 59, 55), 40, 5);
			frame = new Frame(bank);
			frame.getBankBooths().setColors(setup.getColorWaiting().getColor(), 
											setup.getColorServing().getColor(), 
											setup.getColorFullQueue().getColor(),
											setup.getColorLunchBreak().getColor(),
											setup.getColorClosed().getColor(),
											setup.getColorThreadFailure().getColor());
			frame.getBankBooths().setColoredMode(true);
			frame.setTitle("Bank Simulation - DEFAULT MODE");
			setup.dispose();
		});
		
		exitApp.addActionListener(e->{ System.exit(0); });
	}
	
	private Thread getSession(int milis) {
		Thread thread = new Thread(()->{
			while (true) {
				sleep(milis);
				frame.getBank().setClock(new Clock(11, 59, 55));
				sleep(milis);
				frame.getBank().setClock(new Clock(12, 59, 55));
				sleep(milis);
				frame.getBank().setClock(new Clock(17, 59, 55));
				sleep(milis);
				frame.getBank().setClock(new Clock(7, 59, 55));
			}
		});
		return thread;
	}
	
	private void sleep(int milis) {
		try {
			Thread.sleep(milis);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
	}
	
}