package be.pxl.collections.opdracht1;

public class Card {

	private Color color;
	private Value value;
	
	public Card(Color color, Value value) {
		this.setColor(color);
		this.setValue(value);
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public Value getValue() {
		return value;
	}

	public void setValue(Value value) {
		this.value = value;
	}

	public int compareTo(Card c2) {
		return 0;
	}
	
}