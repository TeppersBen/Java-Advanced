package com.engine.utils;

import java.awt.GridLayout;

import com.engine.Bank;

public class SizeCalculator {

	public static void getFixedSize(GridLayout layout, Bank bank) {
		int value = 1;
		int boothSize = bank.getBankBooths().size();
		if (boothSize % 5 == 0) {
			if (boothSize != 25) {
				layout.setColumns(boothSize / 5);
				layout.setRows(5);
				return;
			}
		}
		for (int i = 1; i <= 10; i++) {
			value = i * i;
			if (value == boothSize) {
				layout.setColumns(i);
				layout.setRows(i);
				return;
			}
			if (value > boothSize && value <= ((i+1) * (i+1))) {
				layout.setColumns(i+1);
				layout.setRows(i);
				return;
			}
		}
	}
	
}
