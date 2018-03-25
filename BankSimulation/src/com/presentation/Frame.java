package com.presentation;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.engine.Bank;
import com.presentation.panels.PanelBankBooths;
import com.presentation.panels.PanelLogger;
import com.presentation.panels.PanelSettings;
import com.presentation.panels.PanelStatistics;

/**
 * Ignore this class.. it's really messy.. just to visualize the simulation without any stupid console..
 */
public class Frame extends JFrame {

	private static final long serialVersionUID = -307671341918752438L;

	private Bank bank;
	private JLabel clockLabel;
	
	private JTabbedPane pane;
	
	private PanelBankBooths panelBankBooths;
	
	public Frame(Bank bank) {
		super("Bank Simulation");
		this.bank = bank;
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		
		clockLabel = new JLabel(bank.getClock().toString());
		JPanel panel = new JPanel();
		panel.add(clockLabel);
		add(panel, BorderLayout.NORTH);
		pane = new JTabbedPane();
		panelBankBooths = new PanelBankBooths(bank);
		pane.add("BankBooths", panelBankBooths);
		pane.add("Statistics", new PanelStatistics(bank));
		pane.add("Settings", new PanelSettings(this));
		pane.add("Logger", new PanelLogger());
		add(pane, BorderLayout.CENTER);
		updateThread.start();
		clockThread.start();
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	Thread clockThread = new Thread(() -> {
		while (true) {
			clockLabel.setText(bank.getClock().toString()); 
			try {
				Thread.sleep(bank.getClock().getClockSpeed());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	});
	
	Thread updateThread = new Thread(() -> { 
		while (true) {
			panelBankBooths.update();
			try {
				Thread.sleep(900);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}		
	});
	
	public PanelBankBooths getBankBooths() {
		return panelBankBooths;
	}
	
	public Bank getBank() {
		return bank;
	}
	
	public JTabbedPane getTabbedPane() {
		return pane;
	}
}