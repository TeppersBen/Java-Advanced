package be.pxl.generics.opdracht3;

public class WorkingPlaceUtility {
	public static <T> int getScore(WorkingPlace<?> workingPlace) {
		return workingPlace.getNumberOfThingsFixed();
	}
}
