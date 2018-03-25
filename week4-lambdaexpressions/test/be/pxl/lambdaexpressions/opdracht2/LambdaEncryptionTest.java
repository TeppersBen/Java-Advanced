package be.pxl.lambdaexpressions.opdracht2;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import be.pxl.lambdaexpressions.opdracht2.Cryptograaf;

public class LambdaEncryptionTest {
	private static final String ORIGINAL_MESSAGE_LAMBDA = "Sam2!";
	private static final String ENCRYPTED_MESSAGE_LAMBDA = "xfr2!";
	
	private static final String ORIGINAL_MESSAGE_LAMBDA_WRAP = "_Zeta_!";
	private static final String ENCRYPTED_MESSAGE_LAMBDA_WRAP = "_glah_!";
	
	@Test
	public void BasicLambdaEncryption() {
		String encrypted = Cryptograaf.encryptLambda(ORIGINAL_MESSAGE_LAMBDA);
		assertEquals(ENCRYPTED_MESSAGE_LAMBDA, encrypted);
	}
	
	@Test
	public void WrapCharactersAboveZ() {
		String encrypted = Cryptograaf.encryptLambda(ORIGINAL_MESSAGE_LAMBDA_WRAP);
		assertEquals(ENCRYPTED_MESSAGE_LAMBDA_WRAP, encrypted);
	}
}
