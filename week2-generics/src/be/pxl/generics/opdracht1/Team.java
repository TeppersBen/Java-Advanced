package be.pxl.generics.opdracht1;

import java.util.ArrayList;

public class Team<T> {

	private String name;
	private int played;
	private int won;
	private int lost;
	private int tied;
	private ArrayList<T> members = new ArrayList<>();
	
	public Team(String name) {
		this.name = name;
	}
	
	@SuppressWarnings("unchecked")
	public void addPlayer(T player) {
		getList().add(player);
	}
	
	public int numberOfPlayers() {
		return getList().size();
	}
	
	public void matchResult(Team<T> opponent, int ourScore, int theirScore) {
		if (ourScore > theirScore) {
			won++;
			opponent.lost++;
		} else if (ourScore < theirScore) {
			lost++;
			opponent.won++;
		} else {
			tied++;
			opponent.tied++;
		}
	}
	
	public int ranking() {
		return won*3 + tied;
	}
	
	public String getName() {
		return name;
	}
	
	public int getPlayed() {
		return played;
	}
	
	public int getWon() {
		return won;
	}
	
	public int getLost() {
		return lost;
	}
	
	public int getTied() {
		return tied;
	}
	
	@SuppressWarnings("rawtypes")
	public ArrayList getList() {
		return members;
	}	
}