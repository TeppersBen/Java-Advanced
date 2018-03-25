package be.pxl.lambdaexpressions.opdracht2;

public class Bericht {
	private String tekst;
	
	public Bericht(String tekst) {
		setTekst(tekst);
	}
	
	public String encrypt(Encryptie encrypt) {
		return encrypt.apply(tekst);
	}
	
	public void setTekst(String tekst) {
		this.tekst = tekst;
	}
}