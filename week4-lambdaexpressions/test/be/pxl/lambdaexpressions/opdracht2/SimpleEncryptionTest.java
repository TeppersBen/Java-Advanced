package be.pxl.lambdaexpressions.opdracht2;

import org.junit.Test;

import be.pxl.lambdaexpressions.opdracht2.Cryptograaf;

import static org.junit.Assert.assertEquals;


public class SimpleEncryptionTest {
	private static final String ORIGINAL_MESSAGE_SIMPLE = "Sam1!";
	private static final String ENCRYPTED_MESSAGE_SIMPLE = "28-10-22-1-!";
	
	@Test
	public void simpleEncryption() {
		String encrypted = Cryptograaf.encryptSimple(ORIGINAL_MESSAGE_SIMPLE);
		assertEquals(ENCRYPTED_MESSAGE_SIMPLE, encrypted);
	}
}
