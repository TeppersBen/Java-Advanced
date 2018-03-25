package be.pxl.generics.opdracht1;

public class Opdracht1Launcher {

	public static void main(String[] args) {
		Team<SoccerPlayer> redskins = new Team<>("Redskins");
		Team<SoccerPlayer> dolphins = new Team<>("Dolphins");
		
		League<SoccerPlayer> league = new League<>();
		league.addTeam(redskins);
		league.addTeam(dolphins);
		
		redskins.addPlayer(new SoccerPlayer("Josephe"));
		redskins.addPlayer(new SoccerPlayer("Michael"));
		dolphins.addPlayer(new SoccerPlayer("nerd 1"));
		dolphins.addPlayer(new SoccerPlayer("nerd 2"));
		
		System.out.println(redskins.numberOfPlayers());
		
		redskins.matchResult(dolphins, 5, 5); //TIE
		redskins.matchResult(dolphins, 5, 6); //LOST
		redskins.matchResult(dolphins, 6, 5); //WON
		dolphins.matchResult(redskins, 10, 11); //REDSKINS WON
		
		league.printTeams();
	}
	
}