package com.presentation.panels;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import com.engine.Logger;

public class PanelLogger extends JPanel {

	private static final long serialVersionUID = 473056104098309260L;

	public PanelLogger() {
		super(new BorderLayout());
		JTextArea area = new JTextArea();
		JScrollPane pane = new JScrollPane(area);
		Logger.logArea = area;
		area.setFont(new Font("Tahoma", 0, 11));
		area.setWrapStyleWord(true);
		area.setLineWrap(true);
		area.setEnabled(false);
		add(pane);
	}
	
}