package com;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.LocalDate;

public class Maternity {
	public static void main(String[] args) {
		Person create = new Person("Wafke", "Boem", "Rottem", LocalDate.now());
		try {
			FileOutputStream file = new FileOutputStream(create.getFirstName() + create.getLastName() + ".ser");
			ObjectOutputStream out = new ObjectOutputStream(file);
			out.writeObject(create);
			out.close();
			System.in.read(); //keeps the CMD running..
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		}
	}
}
