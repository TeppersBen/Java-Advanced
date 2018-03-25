package be.pxl.lambdaexpressions.opdracht3;

public class Launcher {

	public static void main(String[] args) {
		GameCollection games = new GameCollection();
		games.addGame(new VideoGame("Starcraft", 50, 9.4, new String[] { "RTS", "Blizzard", "sci-fi" }));
		games.addGame(new VideoGame("GTA-V", 60, 9.2, new String[] { "Shooter", "Rockstar" }));
		games.addGame(new VideoGame("WorldOfWarcraft", 45, 7.5, new String[] { "Addiction", "Blizzard", "Unreal" }));
		games.addGame(new VideoGame("Dungeon Defenders I", 0, 8, new String[] { "Hack&Slash", "Rage", "Trendy" }));
		games.addGame(new VideoGame("Dungeon Defenders II", 0, 9.6, new String[] { "Hack&Slash", "Rage", "Trendy" }));
		games.addGame(new VideoGame("Mortal Kombat X", 65, 8.2, new String[] { "Violence", "HardLanguage", "Fighting" }));
		games.addGame(new VideoGame("Destiny Digital Deluxe Edition", 100, 9.1, new String[] { "MMORPG", "Bungie", "Activision" }));
		
		GameBrowser gameBrowser = new GameBrowser(games);
		gameBrowser.showGamesForSearch("star").forEach(System.out::println);
		gameBrowser.showFreeGames().forEach(System.out::println);
		gameBrowser.showGamesInGenre("blizzard").forEach(System.out::println);
	}
	
}