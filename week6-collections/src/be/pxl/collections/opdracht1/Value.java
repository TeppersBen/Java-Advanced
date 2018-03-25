package be.pxl.collections.opdracht1;

public enum Value {
	VALUE_2 (0, "2"),
	VALUE_3 (1, "3"),
	VALUE_4 (2, "4"),
	VALUE_5 (3, "5"),
	VALUE_6 (4, "6"),
	VALUE_7 (5, "7"),
	VALUE_8 (6, "8"),
	VALUE_9 (7, "9"),
	VALUE_10 (8, "10"),
	VALUE_J (9, "J"),
	VALUE_Q (10, "Q"),
	VALUE_K (11, "K"),
	VALUE_A (12, "A");
	
	private final int order;
	private final String name;       

    private Value(int order, String name) {
        this.order = order;
    	this.name= name;
    }
    
    public String toString() {
        return this.name;
    }
    
    public int getOrder() {
    	return this.order;
    }
}
