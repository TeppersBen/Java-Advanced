package be.pxl.collections.opdracht2;

public class Robot {
	private String name;
	
	public Robot(String name) {
		this.name = name;
	}
	
	class Command {
		private Action action;
		private String value;
		
		public Command(Action action, String value) {
			this.action = action;
			this.value = value;
		}
		
		public String display() {
			return action.toString() + " > " + value;
		}
	}
}
