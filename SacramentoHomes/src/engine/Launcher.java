package engine;

public class Launcher {
	public static void main(String[] args) {
		Collection collection = new Collection();
		collection.createCollection();
		
		System.out.println("PropertiesAbovePrice(800000)");
		collection.propertiesAbovePrice(800000);
		System.out.println();
		
		System.out.println("PropertiesForZIPCode(95838)");
		collection.propertiesForZIPCode("95838");
		System.out.println();
		
		System.out.println("PropertiesSoldAfter(null)");
		//collection.propertiesSoldAfter(null);
		System.out.println();
		
		System.out.println("lastPropertiesSold(5)");
		//collection.lastPropertiesSold(5);
		System.out.println();
		
		System.out.println("FindCheapest()");
		System.out.println(collection.findCheapest());
		System.out.println();
	}
}
