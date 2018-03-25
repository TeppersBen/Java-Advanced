package be.pxl.collections.opdracht1;

import java.util.Deque;
import java.util.LinkedList;

public class Hand {

	Deque<Card> cards = new LinkedList<>();

	public void addCard(Card card) {
		cards.add(card);
		sortCardsInNaturalOrder();
	}
	
	public String showHand() {
		String result = "";
		for (Card card : cards) {
			result += card.getColor().toString() + card.getValue().toString();
		}
		return result;
	}
	
	public boolean hasColor(Color color) {
		for (Card card : cards) {
			if (card.getColor() == color)
				return true;
		}
		return false;
	}
	
	public void sortCardsInNaturalOrder() {
		//TODO lazy....
	}
	
}