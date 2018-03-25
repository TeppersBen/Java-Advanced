package be.pxl.generics.opdracht4;

import java.util.ArrayList;

public class Utils {
	
	private static ArrayList<Integer> list;
	private static ArrayList<Object> modifiedList;
	
	public static void maakIntegerLijst(int value) {
		list = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			list.add(value);
		}
	}
	
	public static void printIntegerLijst() {
		list.forEach(e -> {
			System.out.println(e.intValue());
		});
	}
	
	public static void maakModifiedLijst(Object value) {
		modifiedList = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			modifiedList.add(value);
		}
	}
	
	public static void printModifiedLijst() {
		modifiedList.forEach(e -> {
			System.out.println(e.toString());
		});
	}
}