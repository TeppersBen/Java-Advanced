package be.pxl.streams;

import java.util.OptionalInt;
import java.util.Random;
import java.util.stream.IntStream;

public class Challenge2 {
	public static void main(String[] args) {
		// maak een stream met 10 random gehele getallen tussen 0 en 30
		// bekijk hiervoor de methode ints(...) in de klasse Random
		// filter de getallen die deelbaar zijn door 3
		// en geef het maximum 
		// gebruik eventueel peek() om een tussenresultaat van de stream te tonen
		Random r = new Random();
		IntStream stream = r.ints(10, 1, 30)
							.filter(e -> e % 3 == 0);
		//stream.forEach(System.out::println);
		
		OptionalInt max = stream.max();
		System.out.println((max == null) ? 0 : max.getAsInt());
	}
}
