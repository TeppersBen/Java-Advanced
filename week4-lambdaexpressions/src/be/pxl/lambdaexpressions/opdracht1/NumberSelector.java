package be.pxl.lambdaexpressions.opdracht1;

import java.util.function.Function;

public class NumberSelector {
	private NumberMachine numberMachine;
	
	public NumberSelector(NumberMachine numberMachine) {
		this.numberMachine = numberMachine;
	}
	
	public String showEvenNumbers() {
		return numberMachine.processNumbers(new NumberFilter() {
			@Override
			public boolean check(int number) {
				if (number % 2 == 0)
					return true;
				return false;
			}
		});
	}
	
	public String showNumbersAbove(int value) {
		return numberMachine.processNumbers(new NumberFilter() {
			@Override
			public boolean check(int numbers) {
				if (numbers > value)
					return true;
				return false;
			}
		});
	}
	
	public String printHexNumbers() {
		return numberMachine.convertNumbers(new Function<String, String>() {
			@Override
			public String apply(String t) {
				return t.toUpperCase();
			}
		});
	}
	
	public String lambdaShowEvenNumbers() {
		return numberMachine.processNumbers(e -> new Integer(e).intValue() % 2 == 0);
	}
	
	public String lambdaShowNumbersAbove(int value) {
		return numberMachine.processNumbers(e -> new Integer(e).intValue() > value);
	}
	
	public String lambdaShowHexNumbers() {
		return numberMachine.convertNumbers(s -> s.toUpperCase());
	}
}
