package be.pxl.generics.opdracht1;

public abstract class Player {

	private String name;

	public Player(String name) {
		setName(name);
	}
	
	protected String getName() {
		return name;
	}

	protected void setName(String name) {
		this.name = name;
	}
}