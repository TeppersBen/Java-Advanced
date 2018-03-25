package com;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class CivilService {
	public static void main(String[] args) {
		try {
			FileInputStream file = new FileInputStream("WafkeBoem.ser");
			ObjectInputStream in = new ObjectInputStream(file);
			Person display = (Person) in.readObject();
			System.out.println(display.toString());
			in.close();
			System.in.read(); //keeps the CMD running..
		} catch (IOException | ClassNotFoundException ex) {
			System.out.println(ex.getMessage());
		}
	}
}
