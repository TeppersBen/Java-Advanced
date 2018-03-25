package engine;

import java.time.LocalDate;

public class Mapper {

	public Property map(String street, String city, String zip, String state, int beds, int baths, double sq__ft,
			String type, String sale_date, long price, double latitude, double longitude) {
		return new Property(street, city, zip, state, beds, baths, sq__ft, type, createLocalDate(sale_date), price, latitude, longitude);
	}
	
	private LocalDate createLocalDate(String date) {
		String[] segments = date.split(" ");	
		//DateTimeFormatter formatter = DateTimeFormatter.ofPattern("E MMM yyyy");
		return null;//LocalDate.parse(segments[1] + " " + segments[2] + " " + segments[5], formatter); Repeating Exception in Java 9.0.1
	}
	
}
