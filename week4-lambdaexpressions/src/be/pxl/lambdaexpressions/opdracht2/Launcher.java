package be.pxl.lambdaexpressions.opdracht2;

public class Launcher {

	public static void main(String[] args) {
		final String message = "Mיייייייי, Dikku coode sjrijfen!";
		System.out.println(message);
		System.out.println(Cryptograaf.encryptFirst(message));
		System.out.println(Cryptograaf.lamdaEncryptFirst(message));
		System.out.println(Cryptograaf.encryptSimple(message));
		System.out.println(Cryptograaf.encryptLambda(message));
	}

}