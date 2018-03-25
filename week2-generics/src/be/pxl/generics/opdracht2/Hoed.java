package be.pxl.generics.opdracht2;

public class Hoed<T extends Dier> {

	private T o;
	
	private int view = -1;
	
	public Hoed(T dier) {
		o = dier;
	}
	
	public T kijk() {
		view++;
		return (view == 0) ? null : o;
	}
	
}