import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner userinput = new Scanner(System.in);
		System.out.println("Bitte gib einen Startknoten an:");
		String START = userinput.nextLine();
		System.out.println("Bitte gib einen Endknoten an:");
		String END = userinput.nextLine();
		GraphParser labyrinth = new GraphParser();
		WegSuche wegSuche = new WegSuche(labyrinth.getLabyrinth(), new Knoten(START), new Knoten(END));
		System.out.println(wegSuche.toString());
	}
}
