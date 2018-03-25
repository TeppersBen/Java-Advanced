package be.pxl.lambdaexpressions.opdracht2;

public class Cryptograaf {
	public static String encryptFirst(String tekst) {
		return new Bericht(tekst).encrypt(new Encryptie() {
			@Override
			public String apply(String s) {
				return new StringBuilder(s).reverse().toString();
			}
		});
	}
	
	public static String encryptSimple(String tekst) {
		return new Bericht(tekst).encrypt(new Encryptie() {
			@Override
			public String apply(String s) {
				String result = s.toUpperCase();
				char[] chars = result.toCharArray();
				result = "";
				for (int i = 0; i < chars.length; i++) {
					if (chars[i] >= 'A' && chars[i] <= 'É')
						result += Character.getNumericValue(chars[i]) + (((i+1) == chars.length) ? "" : "-");
					else
						result += chars[i] + (((i+1) == chars.length) ? "" : "-");
				}
				return result;
			}
		});
	}
	
	public static String encryptLambda(String tekst) {
		return new Bericht(tekst).encrypt(s -> {
			String result = tekst.toLowerCase();
			char[] chars = result.toCharArray();
			int step = result.length();
			result = "";
			for (int i = 0; i < chars.length; i++) {
				if (chars[i] >= 'a' && chars[i] <= 'é')
					result += (char) (chars[i] + (step % 26));
				else
					result += chars[i];
			}
			return result;
		});
	}
	
	public static String lamdaEncryptFirst(String tekst) {
		return new Bericht(tekst).encrypt(s -> new StringBuilder(s).reverse().toString());
	}
}