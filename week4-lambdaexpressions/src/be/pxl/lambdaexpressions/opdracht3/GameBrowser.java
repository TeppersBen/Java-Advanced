package be.pxl.lambdaexpressions.opdracht3;

import java.util.ArrayList;

public class GameBrowser {
	private GameCollection gameCollection;
	
	public GameBrowser(GameCollection collection) {
		setGameCollection(collection);
	}
	
	public ArrayList<VideoGame> showGamesForSearch(String name) {
		return gameCollection.selectGames(e -> e.getName().toLowerCase().contains(name.toLowerCase()));
	}
	
	public ArrayList<VideoGame> showFreeGames() {
		return gameCollection.selectGames(e -> e.getPrice() == 0);
	}
	
	public ArrayList<VideoGame> showGamesInGenre(String genre) {
		return gameCollection.selectGames(e -> e.getGenres().stream().anyMatch(t -> t.toLowerCase().equalsIgnoreCase(genre.toLowerCase())));
	}

	public GameCollection getGameCollection() {
		return gameCollection;
	}

	public void setGameCollection(GameCollection gameCollection) {
		this.gameCollection = gameCollection;
	}
}