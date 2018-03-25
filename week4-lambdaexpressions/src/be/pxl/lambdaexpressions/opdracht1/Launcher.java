package be.pxl.lambdaexpressions.opdracht1;

public class Launcher {
	public static void main(String[] args) {
		int[] numbers = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 46};
		NumberMachine numberMachine = new NumberMachine(numbers);
		NumberSelector numberSelector = new NumberSelector(numberMachine);
		System.out.println("regular section");
		System.out.println(numberSelector.showEvenNumbers());
		System.out.println(numberSelector.showNumbersAbove(5));
		System.out.println(numberSelector.printHexNumbers());
		System.out.println("lambda section");
		System.out.println(numberSelector.lambdaShowEvenNumbers());
		System.out.println(numberSelector.lambdaShowNumbersAbove(2));
		System.out.println(numberSelector.lambdaShowHexNumbers());
	}
}