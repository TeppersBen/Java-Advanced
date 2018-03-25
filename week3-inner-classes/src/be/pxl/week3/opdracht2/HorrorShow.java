package be.pxl.week3.opdracht2;

public class HorrorShow {

	public static void main(String[] args) {
		Werewolf werewolf = new Werewolf();
		werewolf.destroy(new Vampire());
		werewolf.destroy(new Vampire() {
			@Override
			public void menance() {
				System.out.println("You smell like wet dog.");
			}
		});
	}
	
	private static class Vampire implements Monster {
		@Override
		public void menance() {
			System.out.println("I'll dink your blood!!");
		}
	}
	
	private static class Werewolf implements DangerousMonster {

		@Override
		public void menance() {
			System.out.println("I'll destory you.");
		}

		@Override
		public void destroy(Monster monster) {
			monster.menance();
			System.out.println("Big fight...");
			System.out.println(getClass().getSimpleName() + " killed one " + monster.getClass().getSimpleName());
		}
		
	}

}