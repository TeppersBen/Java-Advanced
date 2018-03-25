package be.pxl.lambdaexpressions.opdracht3;

import java.util.ArrayList;
import java.util.function.Predicate;

public class GameCollection {
	private ArrayList<VideoGame> videoGames = new ArrayList<>();
	
	public void addGame(VideoGame videoGame) {
		videoGames.add(videoGame);
	}
	
	public ArrayList<VideoGame> selectGames(Predicate<VideoGame> filter) {
		ArrayList<VideoGame> newVideoGames = new ArrayList<>();
		videoGames.forEach(e -> {
			if (filter.test(e))
				newVideoGames.add(e);
		});
		return newVideoGames;
	}
	
	public ArrayList<VideoGame> getVideoGames() {
		return videoGames;
	}
}