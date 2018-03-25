package be.pxl.streams;

public class Person {
	private String name;
	private int age;
	private Gender gender;

	public Person(String name, int age, Gender gender) {
		this.name = name;
		this.age = age;
		this.gender = gender;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public enum Gender {
		MALE, FEMALE;
	}
	
	@Override
	public String toString() {
		return String.format("Person [Name=%s, Age=%d, Gender=%s]", 
							name, age, gender.toString());
	}
}
