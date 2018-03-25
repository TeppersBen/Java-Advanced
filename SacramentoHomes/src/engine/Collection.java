package engine;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Collection {

	private List<Property> list = new ArrayList<>();
	private Writer writer = new Writer();
	
	public void createCollection() {
		list = new Reader().readCSVFile(getClass().getResource("/resources/sacramentorealestatetransactions.csv").getPath());
	}
	
	public void propertiesAbovePrice(int price) {
		List<Property> newList = list.stream().filter(e -> e.getPrice() > price).collect(Collectors.toList());
		writer.WriteCSVFile("propertiesAbovePrice-"+price, newList);
	}
	
	public void propertiesForZIPCode(String zip) {
		List<Property> newList = list.stream().filter(e -> e.getZip().equals(zip)).collect(Collectors.toList());
		writer.WriteCSVFile("propertiesForZIPCode-"+zip, newList);
	}
	
	public void propertiesSoldAfter(LocalDate date) {
		List<Property> newList = list.stream().filter(e -> e.getSale_date().isAfter(date)).collect(Collectors.toList());
		writer.WriteCSVFile("propertiesSoldAfter-"+date, newList);
	}
	
	public void lastPropertiesSold(int amount) {
		List<Property> newList = list.stream().filter(e -> e.getSale_date() != null).collect(Collectors.toList());
		for (int i = 0; i < amount; i++) {
			System.out.println(newList.get(i));
		}
		writer.WriteCSVFile("lastPropertiesSold-"+amount, newList);
	}
	
	public Property findCheapest() {
		List<Property> newList = list.stream().filter(e -> e.getBeds() >= 3)
							.filter(e -> e.getSq__ft() >= 1000)
							.filter(e -> e.getCity().equalsIgnoreCase("Sacramento")).collect(Collectors.toList());
		Property property = null;
		for (Property p : newList) {
			if (property == null)
				property = p;
			else {
				if (property.getPrice() > p.getPrice())
					property = p;
			}
		}
		return property;
	}
}
