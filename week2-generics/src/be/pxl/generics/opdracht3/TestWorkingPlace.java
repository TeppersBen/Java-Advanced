package be.pxl.generics.opdracht3;

public class TestWorkingPlace {
	public static void main(String[] args) {
		Car car = new Car();
		CircularSaw circularSaw = new CircularSaw();
		Bike bike = new Bike();
		
		WorkingPlace<CircularSaw> workingplace = new WorkingPlace<>();
		workingplace.startFixing(circularSaw);
		workingplace.startFixing(circularSaw);
		
		workingplace.finished();
		
		workingplace.startFixing(new CircularSaw());
	}
}
