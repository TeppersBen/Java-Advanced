package be.pxl.lambdaexpressions.opdracht3;

import java.util.ArrayList;

public class VideoGame {
	private String name;
	private double price;
	private double rating;
	private ArrayList<String> genres;
	
	public VideoGame(String name, double price, double rating, String[] genres) {
		setName(name);
		setPrice(price);
		setRating(rating);
		setGenres(genres);
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public void setRating(double rating) {
		this.rating = rating;
	}
	
	public void setGenres(String[] genres) {
		this.genres = new ArrayList<String>();
		for (int i = 0; i < genres.length; i++) {
			this.genres.add(genres[i].toLowerCase());
		}
	}
	
	public String getName() {
		return name;
	}
	
	public double getPrice() {
		return price;
	}
	
	public double getRating() {
		return rating;
	}
	
	public ArrayList<String> getGenres() {
		return genres;
	}
	
	public String toString() {
		return getName() + " " + getPrice() + " " + getRating() + " ";
	}
}