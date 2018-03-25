package be.pxl.collections.opdracht1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Deck {

	Deque<Card> cards = new LinkedList<>();
	
	public Deck() {
		for (Color color : Color.values()) {
			for (Value value : Value.values()) {
				cards.add(new Card(color, value));
			}
		}
		shuffleDeck();
	}
	
	public int getDeckSize() {
		return cards.size();
	}
	
	public Card dealCard() {
		return cards.pollFirst();
	}
	
	public String showDeck() {
		String result = "";
		for (Card card : cards) {
			result += card.getColor().toString() + card.getValue().toString();
		}
		return result;
	}
	
	private void shuffleDeck() {
		List<Card> backup = new ArrayList<>();
		backup.addAll(cards);
		Collections.shuffle(backup);
		cards = new LinkedList<>(backup);
	}
	
}