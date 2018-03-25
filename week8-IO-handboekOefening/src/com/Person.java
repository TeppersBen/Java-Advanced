package com;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Timer;
import java.util.TimerTask;

public class Person implements Serializable {

	private static final long serialVersionUID = 5576608543360068860L;
	
	private String firstName;
	private String lastName;
	private LocalDate birthDay;
	private transient Timer heartbeat;
	private String birthPlace;
	
	public Person(String fName, String lName, String birthPlace, LocalDate bd) {
		setFirstName(fName);
		setLastName(lName);
		setBirthDay(bd);
		setBirthPlace(birthPlace);
		heartbeat = new Timer(true);
		heartbeat.scheduleAtFixedRate(new HeartBeat(), 0, 1000);
	}
	
	private class HeartBeat extends TimerTask {

		@Override
		public void run() {
			System.out.println("*");
		}
		
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public void setBirthDay(LocalDate birthDay) {
		this.birthDay = birthDay;
	}
	
	public void setBirthPlace(String birthPlace) {
		this.birthPlace = (birthPlace == null) ? "UNKNOWN" : birthPlace;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public LocalDate getBirthDay() {
		return birthDay;
	}
	
	public String getBirthPlace() {
		return birthPlace;
	}
	
	public String toString() {
		return "FirstName: " + getFirstName() + "\n" 
			+ "LastName: " + getLastName() + "\n" 
			+ "BirthPlace: " + getBirthPlace() + "\n"
			+ "BirthDay: " + getBirthDay().toString();
	}
	
}