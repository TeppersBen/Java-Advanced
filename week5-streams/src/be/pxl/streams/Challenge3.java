package be.pxl.streams;

import java.util.Arrays;
import java.util.List;

public class Challenge3 {
	public static void main(String[] args) {
		List<String> topNames = Arrays.asList(
                "Amelia",
                "Olivia",
                "emily",
                "Isla",
                "Ava",
                "oliver",
                "Jack",
                "Charlie",
                "harry",
                "Jacob"
        );
		System.out.println("Deel 1:");
		// 1. Druk alle namen van de lijst af in gesorteerde volgorde.
		// Zorg dat de eerste letter van een naam steeds met hoofdletter begint.
		topNames.stream().map(s -> Character.toUpperCase(s.charAt(0)) + s.substring(1))
							.sorted()
							.forEach(System.out::println);
		
		System.out.println("Deel 2:");
		// 2. Druk alle namen af die beginnen met A (of a)
		// Zorg dat de eerste letter van een naam steeds met hoofdletter begint.
		// Verwachte output: Amelia Ava
		topNames.stream().map(s -> Character.toUpperCase(s.charAt(0)) + s.substring(1))
							.filter(s -> s.charAt(0) == 'A')
							.map(s -> s + " ")
							.forEach(System.out::print);
		
		System.out.println("\nDeel 3:");
		// 3. Hoeveel namen beginnen er met A
		// Verwachte output: 2
		long amount = topNames.stream().map(s -> Character.toUpperCase(s.charAt(0)) + s.substring(1))
							.filter(s -> s.charAt(0) == 'A')
							.count();
		System.out.println(amount);
	}
}
