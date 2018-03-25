package be.pxl.collections.opdracht1;

public class Launcher {

	public static void main(String[] args) {
		Deck deck = new Deck();
		System.out.println("Deck-size: " + deck.getDeckSize());
		System.out.println("Deck-DealCard: " + deck.dealCard());
		System.out.println("Deck-size: " + deck.getDeckSize());
		System.out.println("Deck-ShowDeck: " + deck.showDeck());
		
		Hand hand = new Hand();
		hand.addCard(deck.dealCard());
		hand.addCard(deck.dealCard());
		System.out.println("Hand-ShowHand: " + hand.showHand());
		System.out.println("Deck-ShowDeck: " + deck.showDeck());
		System.out.println("Hand-HasColor: " + hand.hasColor(Color.HARTEN));
	}
	
}