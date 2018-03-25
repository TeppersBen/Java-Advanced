package com.presentation.panels;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.util.LinkedList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.engine.Bank;
import com.engine.BankBooth;
import com.engine.entity.Customer;
import com.engine.utils.SizeCalculator;

public class PanelBankBooths extends JPanel {

	private static final long serialVersionUID = 6092841904740672893L;

	private Bank bank;
	private PanelBankBoothsSub[] panels;
	
	private boolean isColorMode;
	
	private GridLayout gridLayout;

	public PanelBankBooths(Bank b) {
		bank = b;
		panels = new PanelBankBoothsSub[b.getBankBooths().size()];
		for (int i = 0; i < panels.length; i++) {
			panels[i] = new PanelBankBoothsSub(bank.getBankBooths().get(i));
			panels[i].setBorder(BorderFactory.createTitledBorder(""));
		}
		LayoutComponents();
	}

	private void LayoutComponents() {
		gridLayout = new GridLayout();
		SizeCalculator.getFixedSize(gridLayout, bank);
		setLayout(gridLayout);
		for (PanelBankBoothsSub panel : panels) {
			add(panel);
		}
	}

	public void update() {
		for (PanelBankBoothsSub panel : panels) {
			panel.update();
		}
	}
	
	public void setColors(Color waiting, Color serving, Color full, Color lunch, Color closed, Color failure) {
		for (PanelBankBoothsSub panel : panels) {
			panel.setColors(waiting, serving, full, lunch, closed, failure);
		}
	}
	
	public void setColoredMode(boolean bool) {
		isColorMode = bool;
		for (PanelBankBoothsSub panel : panels) {
			panel.setColoredMode(bool);
		}
	}
	
	public boolean isColorMode() {
		return isColorMode;
	}

}

class PanelBankBoothsSub extends JPanel {

	private static final long serialVersionUID = 1L;

	private BankBooth bankBooth;
	
	private List<Customer> list;

	private JLabel[] users;
	private String split = "--------------------------------";
	
	private JLabel banker;
	private JLabel split1;
	private JLabel split2;
	private JLabel task;
	
	private boolean isColoredMode;
	
	private Color colorWaiting;
	private Color colorServing;
	private Color colorFull;
	private Color colorLunchBreak;
	private Color colorClosed;
	private Color colorThreadFailure;

	public PanelBankBoothsSub(BankBooth bankBooth) {
		this.bankBooth = bankBooth;
		users = new JLabel[bankBooth.getMaxQueueSize()];
		setLayout(new GridLayout(4 + bankBooth.getMaxQueueSize(), 1));
		banker = new JLabel(bankBooth.getBanker().getFullName());
		banker.setHorizontalAlignment(SwingConstants.CENTER);
		add(banker);
		split1 = new JLabel(split);
		split1.setHorizontalAlignment(SwingConstants.CENTER);
		add(split1);
		task = new JLabel("TASK");
		task.setHorizontalAlignment(SwingConstants.CENTER);
		add(task);
		split2 = new JLabel(split);
		split2.setHorizontalAlignment(SwingConstants.CENTER);
		add(split2);
		for (int i = 0; i < users.length; i++) {
			users[i] = new JLabel("");
			users[i].setHorizontalAlignment(SwingConstants.CENTER);
			add(users[i]);
		}
	}
	
	public void update() {
		task.setText(bankBooth.getThread().getState() == Thread.State.TERMINATED ? "## THREAD FAILURE ##" :
						!bankBooth.hasBanker() ? "Closed" : 
							bankBooth.isAtLunchBreak() ? "Lunch Break" : 
								bankBooth.getBanker().isHelping() ? "Serving" : "Waiting");
		list = new LinkedList<Customer>(bankBooth.getQueue());
		for (int i = 0; i < users.length; i++) {
			if (i < list.size())
				users[i].setText(list.get(i).getFullName());
			else
				users[i].setText("");
		}
	}
	
	public void setColors(Color waiting, Color serving, Color full, Color lunchBreak, Color closed, Color failure) {
		colorWaiting = waiting;
		colorServing = serving;
		colorFull = full;
		colorLunchBreak = lunchBreak;
		colorClosed = closed;
		colorThreadFailure = failure;
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		if (isColoredMode()) {
			if (bankBooth.getThread().getState() == Thread.State.TERMINATED) {
				setBackground(colorThreadFailure);
			} else if (!bankBooth.hasBanker()) {
					setBackground(colorClosed);
			} else if (bankBooth.getBanker().isHelping()) {
				setBackground(colorServing);
			} else if (bankBooth.isFull()) {
				setBackground(colorFull);
			} else if (bankBooth.isAtLunchBreak()) {
				setBackground(colorLunchBreak);
			} else {
				setBackground(colorWaiting);
			}
		} else {
			setBackground(null);
		}
		
	}

	public boolean isColoredMode() {
		return isColoredMode;
	}

	public void setColoredMode(boolean isColoredMode) {
		this.isColoredMode = isColoredMode;
	}
	
	/**
	 * Low performance rating
	 */
	@SuppressWarnings("unused")
	private Thread threadFailure = new Thread(() -> {
		boolean isGoingUp = false;
		float value = 1;
		Color color = Color.getHSBColor(0, 1, value);
		while (true) {
			if (isGoingUp)
				value+=0.05;
			else
				value-=0.05;
			color = Color.getHSBColor(0, 1, value);
			setBackground(color);
			if (value >= 1)
				isGoingUp = false;
			else if (value <= 0.5)
				isGoingUp = true;
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	});

}