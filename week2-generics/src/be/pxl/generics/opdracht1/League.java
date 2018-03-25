package be.pxl.generics.opdracht1;

import java.util.ArrayList;

public class League<T extends Player> {
	
	private ArrayList<Team<T>> teams = new ArrayList<>();

	public void addTeam(Team<T> team) {
		teams.add(team);
	}
	
	public void printTeams() {
		teams.forEach(e -> {
			System.out.println(e.getName() + ": " + e.ranking());
		});
	}
	
}