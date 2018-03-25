package be.pxl.generics.opdracht4;

public class Launcher {

	public static void main(String[] args) {
		Utils.maakIntegerLijst(10);
		Utils.printIntegerLijst();
		
		Utils.maakModifiedLijst(new String("Je weet zelf!"));
		Utils.printModifiedLijst();
	}
	
}