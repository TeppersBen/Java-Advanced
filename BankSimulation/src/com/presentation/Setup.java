package com.presentation;

import static com.engine.utils.AllowedColors.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.engine.Bank;
import com.engine.Clock;
import com.engine.utils.AllowedColors;

public class Setup extends JFrame {

	private static final long serialVersionUID = 5181645782715206126L;

	private TextField txtClockTime;
	private TextField txtAmountOfBooths;
	private TextField txtBoothSize;
	
	private JButton btnProcess;
	
	private ColorList colorWaiting;
	private ColorList colorServing;
	private ColorList colorLunchBreak;
	private ColorList colorClosed;
	private ColorList colorFullQueue;
	private ColorList colorThreadFailure;
	
	private boolean isForcedColorMode;
	
	public Setup() {
		super("Setup");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setResizable(false);
		
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		
		new DebugSession(this);
		
		JPanel center = new JPanel(new GridLayout(1, 2));
		center.add(createParameterPanel());
		center.add(createColoredFields());
		
		add(center, BorderLayout.CENTER);
		add(createButtonProcess(), BorderLayout.SOUTH);
		
		addWindowListener(new WindowAdapter() {
		    public void windowOpened(WindowEvent e){
		        btnProcess.requestFocus();
		    }
		}); 
		
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	private JPanel createParameterPanel() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(3, 1));
		panel.add(createClockTime());
		panel.add(createAmountOfBooths());
		panel.add(createBoothSize());
		panel.setBorder(BorderFactory.createTitledBorder("Parameters"));
		return panel;
	}
	
	private JPanel createClockTime() {
		JLabel lblClockTime = new JLabel("Clock Start Time: ");
		txtClockTime = new TextField(14, "HH:mm:ss");
		JPanel panel = new JPanel();
		panel.add(lblClockTime);
		panel.add(txtClockTime);
		return panel;
	}
	
	private JPanel createAmountOfBooths() {
		JLabel lblAmountOfBooths = new JLabel("Amount of Bank Booths: ");
		txtAmountOfBooths = new TextField(10);
		JPanel panel = new JPanel();
		panel.add(lblAmountOfBooths);
		panel.add(txtAmountOfBooths);
		return panel;
	}
	
	private JPanel createBoothSize() {
		JLabel lblBoothSize = new JLabel("Bank Booth Queue Size: ");
		txtBoothSize = new TextField(10);
		JPanel panel = new JPanel();
		panel.add(lblBoothSize);
		panel.add(txtBoothSize);
		return panel;
	}
	
	private JPanel createColoredFields() {
		JPanel panel = new JPanel(new BorderLayout());
		JPanel sub = new JPanel(new GridLayout(3, 2));
		sub.add(createWaitingColor());
		sub.add(createServedColor());
		sub.add(createFullColor());
		sub.add(createLunchBreakColor());
		sub.add(createClosedColor());
		sub.add(createFailureColor());
		panel.add(createButtonIsForcedColoredMode(), BorderLayout.NORTH);
		panel.add(sub, BorderLayout.CENTER);
		panel.setBorder(BorderFactory.createTitledBorder("Colored Mode"));
		return panel;
	}
	
	private JPanel createButtonIsForcedColoredMode() {
		JPanel panel = new JPanel();
		JToggleButton button = new JToggleButton("Forced Colored Mode: Disabled");
		button.addActionListener(e->{
			isForcedColorMode = !isForcedColorMode;
			button.setText("Forced Colored Mode: " + (isForcedColorMode ? "Activated" : "Disabled"));
		});
		panel.add(button);
		return panel;
	}
	
	private JPanel createWaitingColor() {
		JPanel panel = new JPanel();
		JLabel lblwaiting = new JLabel("Waiting: ");
		colorWaiting = new ColorList(YELLOW);
		panel.add(lblwaiting);
		panel.add(colorWaiting);
		return panel;
	}
	
	private JPanel createServedColor() {
		JPanel panel = new JPanel();
		JLabel lblServing = new JLabel("Serving: ");
		colorServing = new ColorList(GREEN);
		panel.add(lblServing);
		panel.add(colorServing);
		return panel;
	}
	
	private JPanel createFullColor() {
		JPanel panel = new JPanel();
		JLabel lblFullQueue = new JLabel("Full Queue: ");
		colorFullQueue = new ColorList(ORANGE);
		panel.add(lblFullQueue);
		panel.add(colorFullQueue);
		return panel;
	}
	
	private JPanel createLunchBreakColor() {
		JPanel panel = new JPanel();
		JLabel lblLunchBreak = new JLabel("Lunch Break: ");
		colorLunchBreak = new ColorList(DARK_GREEN);
		panel.add(lblLunchBreak);
		panel.add(colorLunchBreak);
		return panel;
	}
	
	private JPanel createClosedColor() {
		JPanel panel = new JPanel();
		JLabel lblClosed = new JLabel("Closed: ");
		colorClosed = new ColorList(CYAN);
		panel.add(lblClosed);
		panel.add(colorClosed);
		return panel;
	}
	
	private JPanel createFailureColor() {
		JPanel panel = new JPanel();
		JLabel lblThreadFailure = new JLabel("Thread Failure: ");
		colorThreadFailure = new ColorList(RED);
		panel.add(lblThreadFailure);
		panel.add(colorThreadFailure);
		return panel;
	}
	
	private JPanel createButtonProcess() {
		JPanel panel = new JPanel();
		btnProcess = new JButton("Generate Bank Simulation");
		
		btnProcess.addActionListener(e->{
			try {
				String[] time = txtClockTime.getText().split(":");
				Clock c = new Clock(Integer.parseInt(time[0]), 
									Integer.parseInt(time[1]), 
									Integer.parseInt(time[2]));
				int booths = Integer.parseInt(txtAmountOfBooths.getText());
				int boothSize = Integer.parseInt(txtBoothSize.getText());
				
				Bank bank = new Bank(c, booths, boothSize);
				Frame frame = new Frame(bank);
				frame.getBankBooths().setColors(colorWaiting.getColor(), 
												colorServing.getColor(), 
												colorFullQueue.getColor(),
												colorLunchBreak.getColor(),
												colorClosed.getColor(),
												colorThreadFailure.getColor());
				frame.getBankBooths().setColoredMode(isForcedColorMode);
				dispose();
			} catch (NumberFormatException ex) {
				JOptionPane.showMessageDialog(null, 
											  "Invalid Field(s) Detected!", 
											  "ERROR", 
											  JOptionPane.ERROR_MESSAGE);
			}
		});
		
		panel.add(btnProcess);
		return panel;
	}
	
	public ColorList getColorWaiting() {
		return colorWaiting;
	}

	public ColorList getColorServing() {
		return colorServing;
	}

	public ColorList getColorLunchBreak() {
		return colorLunchBreak;
	}

	public ColorList getColorClosed() {
		return colorClosed;
	}

	public ColorList getColorFullQueue() {
		return colorFullQueue;
	}

	public ColorList getColorThreadFailure() {
		return colorThreadFailure;
	}

	public boolean isForcedColorMode() {
		return isForcedColorMode;
	}
	
}

class ColorList extends JComboBox<String> {

	private static final long serialVersionUID = 8400761789456936463L;

	public ColorList(AllowedColors defaultColor) {
		for (AllowedColors c : AllowedColors.values()) {
			addItem(c.name());
		}
		setSelectedItem(defaultColor.name());
	}
	
	public Color getColor() {
		return AllowedColors.getColorByName((String)getSelectedItem());
	}
}

class TextField extends JTextField {

	private static final long serialVersionUID = 1691849948846200668L;

	private String filterName;
	
	public TextField() {
		this("");
	}
	
	public TextField(String filterName) {
		this(2, filterName);
	}
	
	public TextField(int size, String filterName) {
		super(size);
		this.filterName = filterName;
		createFieldFocusUtility();
	}
	
	public TextField(int size) {
		super(size);
		this.filterName = "";
		createFieldFocusUtility();
	}
	
	public boolean isEmpty() {
		if (getText().equalsIgnoreCase(filterName))
			return true;
		if (getText().equalsIgnoreCase(""))
			return true;
		return false;
	}
	
	private void createFieldFocusUtility() {
		setForeground(Color.GRAY);
		setText(filterName);
		addFocusListener(new FocusListener() {
		    @Override
		    public void focusGained(FocusEvent e) {
		        if (getText().equals(filterName)) {
		        	setText("");
		        	setForeground(Color.BLACK);
		        }
		    }
		    @Override
		    public void focusLost(FocusEvent e) {
		        if (getText().isEmpty()) {
		        	setForeground(Color.GRAY);
		        	setText(filterName);
		        }
		    }
		});
	}
	
}