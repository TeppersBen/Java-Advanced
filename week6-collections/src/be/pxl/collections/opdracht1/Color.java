package be.pxl.collections.opdracht1;

public enum Color {
	KLAVEREN (0, "K"),
	RUITEN (1, "R"),
	SCHOPPEN (2, "S"),
	HARTEN (3, "H");
	
	private final int order;
	private final String name;

    private Color(int order, String name) {
        this.order = order;
        this.name = name;
    }
    
    public String toString() {
        return this.name;
    }
    
    public int getOrder() {
        return this.order;
    }
}
