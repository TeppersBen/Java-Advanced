package com.presentation.panels;

import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.engine.Bank;
import com.engine.BankBooth;
import com.engine.utils.SizeCalculator;

public class PanelStatistics extends JPanel {

	private static final long serialVersionUID = -6769195197644272316L;

	private Bank bank;
	private PanelStatisticsSub[] panels;
	
	private GridLayout gridLayout;
	
	public PanelStatistics(Bank b) {
		bank = b;
		panels = new PanelStatisticsSub[b.getBankBooths().size()];
		for (int i = 0; i < panels.length; i++) {
			panels[i] = new PanelStatisticsSub(bank.getBankBooths().get(i));
			panels[i].setBorder(BorderFactory.createTitledBorder(""));
		}
		LayoutComponents();
		statisticsThread.start();
	}
	
	private void LayoutComponents() {
		gridLayout = new GridLayout();
		SizeCalculator.getFixedSize(gridLayout, bank);
		setLayout(gridLayout);
		for (PanelStatisticsSub panel : panels) {
			add(panel);
		}
	}
	
	public Bank getBank() {
		return bank;
	}

	public void setBank(Bank bank) {
		this.bank = bank;
	}
	
	private Thread statisticsThread = new Thread(() -> {
		while (true) {
			for (int i = 0; i < panels.length; i++) {
				panels[i].update();
			}
		}
	});
	
}

class PanelStatisticsSub extends JPanel {

	private static final long serialVersionUID = 1L;

	private BankBooth bankBooth;

	private JLabel[] labels;
	private String split = "--------------------------------";
	
	private JLabel banker;
	private JLabel split1;

	public PanelStatisticsSub(BankBooth bankBooth) {
		this.bankBooth = bankBooth;
		labels = new JLabel[bankBooth.getMaxQueueSize()];
		setLayout(new GridLayout(4 + bankBooth.getMaxQueueSize(), 1));
		banker = new JLabel(bankBooth.getBanker().getFullName());
		banker.setHorizontalAlignment(SwingConstants.CENTER);
		add(banker);
		split1 = new JLabel(split);
		split1.setHorizontalAlignment(SwingConstants.CENTER);
		add(split1);
		for (int i = 0; i < labels.length; i++) {
			labels[i] = new JLabel("");
			labels[i].setHorizontalAlignment(SwingConstants.CENTER);
			add(labels[i]);
		}
		update();
	}
	
	public void update() {
		labels[0].setText("Served people: " + bankBooth.getBanker().getStats().getServedPeople());
	}

}