package be.pxl.lambdaexpressions.opdracht1;

import java.util.ArrayList;
import java.util.function.Function;

public class NumberMachine {
	private ArrayList<Integer> numbers = new ArrayList<>();
	
	public NumberMachine(int[] numbers) {
		for(int i=0;i<numbers.length;i++)
			this.numbers.add(numbers[i]);
	}
	
	public String processNumbers(NumberFilter filter) {
		String result = "";
		for(int i=0;i<numbers.size();i++) {
			if(filter.check(numbers.get(i))) {
				result += numbers.get(i) + (((i+1) == numbers.size()) ? "" : "-");
			}
		}
		return result;
	}
	
	public String convertNumbers(Function<String, String> filter) {
		String result = "";
		for(int i=0;i<numbers.size();i++) {
			result += Integer.toHexString(numbers.get(i)) + (((i+1) == numbers.size()) ? "" : "-");
		}
		return filter.apply(result);
	}
}
