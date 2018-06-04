package Domain;

public class Main {
	public static void main(String[] args){
		Human Arthur = new Human("Артур", new Feeling(Feelings.NORMAL.toString()));
		Human Ford = new Human("Форд", new Feeling(Feelings.NORMAL.toString()));

		Fish fish = new Fish( "Форд");
		Ford.clap(fish, Arthur);

		if (Arthur.getFeeling().equals(new Feeling(Feelings.EARFEELING.toString()))){
			Human You = new Human("Вы",new Feeling(Feelings.EYEFEELING.toString()));
			You.lookAtTheTwoBlackSilhouettes();
			if (You.lookAtTheColoredDotsOnThePaper()){
				EyeDoctor eyeDoctor = new EyeDoctor();
				eyeDoctor.writeBill();
			}
		}

	}
}