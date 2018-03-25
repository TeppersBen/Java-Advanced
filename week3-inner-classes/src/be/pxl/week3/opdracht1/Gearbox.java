package be.pxl.week3.opdracht1;

import java.util.ArrayList;

public class Gearbox {

	private int maxGears;
	private int currentGear;
	private boolean clutchIsIn;
	private ArrayList<Gear> array = new ArrayList<>();
	
	public Gearbox(int maxGears) {
		this.maxGears = maxGears;
		for (int i = 0; i < maxGears; i++) {
			addGear(new Gear(i));
		}
	}
	
	public void changeGear(int newGear) {
		if (currentGear - newGear >= -1 && currentGear - newGear <= 1 && clutchIsIn == true) {
			currentGear = newGear;
			System.out.println("Gear " + newGear + " selected.");
		} else {
			System.out.println("KRRRKRKKRKRKRKRR.. Pfuu Pfuu.. :'(");
		}
	}
	
	public double wheelSpeed(int revs) {
		if (clutchIsIn == false) {
			return array.get(currentGear).driveSpeed(revs);
		} else {
			System.out.println("KRRRKRKKRKRKRKRR.. Pfuu Pfuu.. :'(");
			return 0;
		}
	}
	
	public void addGear(Gear gear) {
		array.add(gear);
	}
	
	public void operateClutch(boolean in) {
		clutchIsIn = in;
	}
	
	private class Gear {
		private int gearNumber;
		private double ratio;
		
		public Gear(int gearNumber) {
			this.gearNumber = gearNumber;
			ratio = gearNumber * 5.3;
		}
		
		public double driveSpeed(int revs) {
			return revs*ratio;
		}
	}
	
}
