package com.presentation.panels;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JToggleButton;

import com.engine.Bank;
import com.presentation.Frame;

public class PanelSettings extends JPanel {

	private static final long serialVersionUID = -209879967395009840L;

	private Bank bank;
	private Frame frame;
	
	private JSlider sliderClock;
	private JSlider sliderDensity;
	private JToggleButton btnBankBoothColorMode;
	
	public PanelSettings(Frame frame) {
		this.frame = frame;
		bank = frame.getBank();
		setLayout(new GridLayout(3, 1));
		setClockSpeedPanel();
		setBankDensityPanel();
		setBankBoothColorMode();
		initListener();
	}
	
	private void setClockSpeedPanel() {
		JPanel panel = new JPanel(new FlowLayout());
		sliderClock = new JSlider(0, 100, 0);
		JLabel lblClock = new JLabel("Clock Speed:");
		sliderClock.setMajorTickSpacing(10);
		sliderClock.setMinorTickSpacing(1);
		sliderClock.setPaintTicks(true);
		sliderClock.setPaintLabels(true);
		panel.add(lblClock);
		panel.add(sliderClock);
		add(panel);
	}
	
	private void setBankDensityPanel() {
		JPanel panel = new JPanel(new FlowLayout());
		sliderDensity = new JSlider(0, 10, 0);
		JLabel lblDensity = new JLabel("Density:");
		sliderDensity.setMajorTickSpacing(1);
		sliderDensity.setMinorTickSpacing(1);
		sliderDensity.setPaintTicks(true);
		sliderDensity.setPaintLabels(true);
		panel.add(lblDensity);
		panel.add(sliderDensity);
		add(panel);
	}
	
	private void setBankBoothColorMode() {
		JPanel panel = new JPanel(new FlowLayout());
		btnBankBoothColorMode = new JToggleButton(frame.getBankBooths().isColorMode() ? "Enabled" : "Disabled");
		JLabel lblDensity = new JLabel("Bank Booth Color Mode:");
		panel.add(lblDensity);
		panel.add(btnBankBoothColorMode);
		add(panel);
	}
	
	private void initListener() {
		sliderClock.addChangeListener(e -> {
			bank.getClock().setClockSpeed(sliderClock.getValue());
		});
		sliderDensity.addChangeListener(e -> {
			bank.getBankBooths().forEach(x -> {
				x.setDensity(sliderDensity.getValue());
			});
		});
		btnBankBoothColorMode.addActionListener(e -> {
			frame.getBankBooths().setColoredMode(!frame.getBankBooths().isColorMode());
			btnBankBoothColorMode.setText(frame.getBankBooths().isColorMode() ? "Enabled" : "Disabled");
		});
	}
	
}