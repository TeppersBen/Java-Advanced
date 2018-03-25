package be.pxl.streams;

import java.util.Arrays;
import java.util.List;

public class Challenge1 {
	public static void main(String[] args) {
		List<String> tombolaNummers = Arrays.asList("A12", "a20", "B120", "b72", "d53", "D42", "d50", "F12");
		// print alle tombolanummers die starten met D (of d) gesorteerd, steeds met de eerste letter in uppercase
		// Gewenste output: D42 D50 D53 
		tombolaNummers.stream().filter(s -> s.substring(0, 1).equalsIgnoreCase("d"))
								.map(s -> Character.toUpperCase(s.charAt(0)) + s.substring(1))
								.sorted()
								.map(s -> s + " ")
								.forEach(System.out::print);
	}
}
