package engine;

import java.time.LocalDate;

public class Property {
	private String street;
	private String city;
	private String zip;
	private String state;
	private int beds;
	private int baths;
	private double sq__ft;
	private String type;
	private LocalDate sale_date;
	private long price;
	private double latitude;
	private double longitude;
	
	public Property(String street, String city, String zip, String state, int beds, int baths, double sq__ft,
			String type, LocalDate sale_date, long price, double latitude, double longitude) {
		super();
		this.street = street;
		this.city = city;
		this.zip = zip;
		this.state = state;
		this.beds = beds;
		this.baths = baths;
		this.sq__ft = sq__ft;
		this.type = type;
		this.sale_date = sale_date;
		this.price = price;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getBeds() {
		return beds;
	}

	public void setBeds(int beds) {
		this.beds = beds;
	}

	public int getBaths() {
		return baths;
	}

	public void setBaths(int baths) {
		this.baths = baths;
	}

	public double getSq__ft() {
		return sq__ft;
	}

	public void setSq__ft(double sq__ft) {
		this.sq__ft = sq__ft;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public LocalDate getSale_date() {
		return sale_date;
	}

	public void setSale_date(LocalDate sale_date) {
		this.sale_date = sale_date;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	
	public String toString() {
		return street + "," + city + "," + zip + "," + state + "," + beds 
			   + "," + baths + "," + sq__ft + "," + type + "," + sale_date
			   + "," + price + "," + latitude + "," + longitude;
	}
}
