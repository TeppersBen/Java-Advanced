package com.engine;

import javax.swing.JTextArea;

public class Logger {

	public static JTextArea logArea;
	
	public static synchronized void log(String message) {
		if (logArea == null) return;
		logArea.append(message + "\n");
		logArea.setCaretPosition(logArea.getDocument().getLength());
	}
	
}
