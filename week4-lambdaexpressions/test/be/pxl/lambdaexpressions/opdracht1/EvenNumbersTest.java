package be.pxl.lambdaexpressions.opdracht1;

import static org.junit.Assert.*;

import org.junit.Test;

public class EvenNumbersTest {
	
	private static final int[] NUMBERS_INPUT = new int[] {1, 17, 24, 132, 0};
	private static final String EXPECTED_OUTPUT = "24-132-0";
	
	@Test
	public void checkResultFormatting() {
		NumberMachine machine = new NumberMachine(NUMBERS_INPUT);
		NumberSelector selector = new NumberSelector(machine);
		
		String result = selector.showEvenNumbers();
		
		if(result.length() == 0) return;
		
		String first = result.substring(0, 1);
		String last = result.substring(result.length()-1);
		
		assertFalse(first.equals("-"));
		assertFalse(last.equals("-"));
	}
	
	@Test
	public void onlyEvenNumbersRemain() {
		NumberMachine machine = new NumberMachine(NUMBERS_INPUT);
		NumberSelector selector = new NumberSelector(machine);
		
		assertEquals(EXPECTED_OUTPUT, selector.showEvenNumbers());
	}
}
