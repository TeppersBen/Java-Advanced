package be.pxl.collections.opdracht1;

import static org.junit.Assert.*;

import org.junit.Test;

public class CardTest {

	private static final int FULL_DECK_SIZE = 52;
	
	private static final String HAND_SORT_1 = "R3R8";
	private static final String HAND_SORT_2 = "R3R8RQ";
	private static final String HAND_SORT_3 = "R3R8RQHA";
	private static final String HAND_SORT_4 = "K6R3R8RQHA";
	private static final String HAND_SORT_5 = "K6R3R8RQSKHA";
	
	@Test
	public void controlDeckSize() {
		Deck deck = new Deck();
		assertEquals(FULL_DECK_SIZE, deck.getDeckSize());
	}
	
	@Test
	public void decksAreRandomlyShuffled() {
		Deck deck1 = new Deck();
		Deck deck2 = new Deck();
		
		assertNotEquals(deck1.showDeck(), deck2.showDeck()); 
		/*
		 *  Note: there's a very,very,very,VERY small chance that two decks are shuffled in exactly the same way: 
		 *  https://math.stackexchange.com/questions/671/when-you-randomly-shuffle-a-deck-of-cards-what-is-the-probability-that-it-is-a 
		 */
	}
	
	@Test
	public void dealingCardReducesDeckSize() {
		Deck deck = new Deck();
		Card c = deck.dealCard();
		assertEquals(FULL_DECK_SIZE - 1, deck.getDeckSize());
	}
	
	@Test
	public void cardsCompareColor() {
		Card c1 = new Card(Color.HARTEN, Value.VALUE_4);
		Card c2 = new Card(Color.SCHOPPEN, Value.VALUE_4);
		
		assert(c1.compareTo(c2) > 0);
	}
	
	@Test
	public void cardsCompareValue() {
		Card c1 = new Card(Color.HARTEN, Value.VALUE_4);
		Card c2 = new Card(Color.HARTEN, Value.VALUE_J);
		
		assert(c1.compareTo(c2) < 0);
	}
	
	@Test
	public void cardsCombineCompare() {
		Card c1 = new Card(Color.RUITEN, Value.VALUE_4);
		Card c2 = new Card(Color.KLAVEREN, Value.VALUE_J);
		
		assert(c1.compareTo(c2) > 0);
	}
	
	@Test
	public void hasColorReturnsTrueIfColorAvailable() {
		Hand hand = new Hand();
		hand.addCard(new Card(Color.HARTEN, Value.VALUE_10));
		hand.addCard(new Card(Color.SCHOPPEN, Value.VALUE_4));
		
		assertTrue(hand.hasColor(Color.HARTEN));
	}
	
	@Test
	public void hasColorReturnsFalseIfColorNotAvailable() {
		Hand hand = new Hand();
		hand.addCard(new Card(Color.HARTEN, Value.VALUE_10));
		hand.addCard(new Card(Color.SCHOPPEN, Value.VALUE_4));
		
		assertFalse(hand.hasColor(Color.RUITEN));
	}
	
	@Test
	public void handIsAlwaysSorted() {
		Hand hand = new Hand();
		
		hand.addCard(new Card(Color.RUITEN, Value.VALUE_3));
		hand.addCard(new Card(Color.RUITEN, Value.VALUE_8));
		assertEquals(HAND_SORT_1, hand.showHand());
		
		hand.addCard(new Card(Color.RUITEN, Value.VALUE_Q));
		assertEquals(HAND_SORT_2, hand.showHand());		
		
		hand.addCard(new Card(Color.HARTEN, Value.VALUE_A));
		assertEquals(HAND_SORT_3, hand.showHand());		
		
		hand.addCard(new Card(Color.KLAVEREN, Value.VALUE_6));
		assertEquals(HAND_SORT_4, hand.showHand());		
		
		hand.addCard(new Card(Color.SCHOPPEN, Value.VALUE_K));
		assertEquals(HAND_SORT_5, hand.showHand());
	}
}
