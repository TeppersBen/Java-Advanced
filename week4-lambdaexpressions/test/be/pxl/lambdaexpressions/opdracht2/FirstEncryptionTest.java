package be.pxl.lambdaexpressions.opdracht2;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import be.pxl.lambdaexpressions.opdracht2.Cryptograaf;

public class FirstEncryptionTest {
	private static final String ORIGINAL_MESSAGE_FIRST = "Sam0!";
	private static final String ENCRYPTED_MESSAGE_FIRST = "!0maS";
	
	@Test
	public void firstEncryption() {
		String encrypted = Cryptograaf.encryptFirst(ORIGINAL_MESSAGE_FIRST);
		assertEquals(ENCRYPTED_MESSAGE_FIRST, encrypted);
	}
}
