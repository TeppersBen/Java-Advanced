package be.pxl.streams;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;

import be.pxl.streams.Person.Gender;

public class Challenge4 {
	public static void main(String[] args) {
		List<Person> personen = Arrays.asList(new Person("Sofie", 23, Gender.FEMALE),
				new Person("Adam", 31, Gender.MALE), new Person("Bastiaan", 25, Gender.MALE),
				new Person("Berend", 22, Gender.MALE), new Person("Aagje", 27, Gender.FEMALE));
		// 1. Geef de gemiddelde leeftijd van alle personen
		// Verwachte output: Gemiddelde leeftijd: 25.6
		OptionalDouble a = personen.stream().mapToInt(Person::getAge).average();
		System.out.println("Gemiddelde leeftijd: " + a.getAsDouble());

		// 2. Hoeveel mannen staan er in de lijst
		// Verwachte output: Aantal mannen: 3
		long b = personen.stream().filter(p -> p.getGender() == Gender.MALE).count();
		System.out.println("Aantal mannen: " + b);

		// 3. Hoeveel mannen ouder dan 24 staan er in de lijst
		// Verwachte output: Aantal mannen boven 24: 2
		long c = personen.stream().filter(p -> p.getGender() == Gender.MALE).filter(p -> p.getAge() > 24).count();
		System.out.println("Aantal mannen boven 24: " + c);

		// 4. Geef de gemiddelde leeftijd van alle mannen
		// Gemiddelde leeftijd mannen: 26.0
		OptionalDouble d = personen.stream().filter(p -> p.getGender() == Gender.MALE).mapToInt(Person::getAge).average();
		System.out.println("Gemiddelde leeftijd mannen: " + d.getAsDouble());

		// 5. Maak een nieuwe persoon met als naam de eerste letter van iedere
		// persoon in de lijst
		// en als leeftijd de som van alle leeftijden
		// Maak gebruik van de methode .reduce()
		String naam = personen.stream().map(p -> p.getName().substring(0, 1)).reduce("", String::concat).toString();
		int leeftijd = personen.stream().mapToInt(Person::getAge).sum();
		Person persoon = new Person(naam, leeftijd, Gender.MALE);
		System.out.println(persoon.toString());
	}
}
