import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
/**
 * Implementiert einen Parser, der einen Graphen(Labyrinth) aus einer Datei mit geg. Kanten erstellt
 */
public class GraphParser {
	//Attribute
	private Graph labyrinth;

	public GraphParser() {
		startParser();
	}
	
	/**
	 * Konvertiert eingelesene Datei. Liest alle Knoten ein und speichert diese in Knotenliste des Grpahen
	 * Fügt außerdem alle Knoten einer HashMap hinzu (als Schlüssel) und fügt alle Nachbarn eines Knoten zu einer Nachbar Liste in die HashMap ein
	 * Wenn eine Kante weniger als zwei Knoten bzw. mehr als zwei Knoten enthält, wird ein Fehler ausgegeben und das Programm terminiert
	 * @param dateipfad Dateipfad zu der Datei, welche die Methode konvertieren soll
	 */
	public void parseKnoten(String dateipfad) {
	
		try {
			Scanner scanner = new Scanner(new File(dateipfad));
			//Prüft, ob Scanner am Ende der Datei angelangt ist
			while(scanner.hasNext()) {
				String line = scanner.nextLine();
				String[] zeileKnoten = line.split(" ");
				
				if (zeileKnoten.length < 2 || zeileKnoten.length > 2) {
					System.err.println("Kantenliste ist unvollständig.");
					System.exit(1);
				}
				Knoten knoten1 = new Knoten(zeileKnoten[0]);
				Knoten knoten2 = new Knoten(zeileKnoten[1]);
				if(!(labyrinth.getKnoten().contains(knoten1))) {
					labyrinth.addKnoten(knoten1);
					labyrinth.getNachbarKnoten().put(knoten1, new ArrayList<Knoten>());
					labyrinth.addNachbar(knoten1, knoten2);
				} else if(!labyrinth.getNachbarn(knoten1).contains(knoten2)) {
					labyrinth.addNachbar(knoten1, knoten2);
				}
				if(!(labyrinth.getKnoten().contains(knoten2))) {
					labyrinth.addKnoten(knoten2);
					labyrinth.getNachbarKnoten().put(knoten2, new ArrayList<Knoten>());
					labyrinth.addNachbar(knoten2, knoten1);
				} else if(!labyrinth.getNachbarn(knoten2).contains(knoten1)) {
					labyrinth.addNachbar(knoten2, knoten1);
				}
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Benötigt Eingabe, um Parser zu starten, verwendet dann dazu die parseKnoten Methode
	 * Terminiert Programm, wenn keine gültige Eingabe gemacht wird
	 */
	public void startParser() {
		Scanner userinput = new Scanner(System.in);
		this.labyrinth = new Graph();
		System.out.println("Bitte gib ein Labyrinth ein:");
		String labyrinthName = userinput.nextLine();
		switch(labyrinthName) {
			case "Labyrinth 1":
			case "1":
				parseKnoten("/Users/jenni/IdeaProjects/Labyrinth Final/src/labyrinth-1.graph.txt");
				//hier Dateipfad für die labyrinth-1.graph Datei angeben
				break;
			case"Labyrinth2":
			case "2":
				parseKnoten("/Users/jenni/IdeaProjects/Labyrinth Final/src/labyrinth-2.graph.txt");
				break;
			//nur zum debuggen
			//case "test":
			//	case "3":
			//		parseKnoten("/Users/jenni/IdeaProjects/Labyrinth Final/src/test.txt");
			//		break;
			default:
				System.err.println("Ungültiger Name.");
				System.exit(1);
		}
		userinput.close();
	}

	/**
	 * Getter
	 * @return Gibt fertigen Graphen(Labyrinth) aus
	 */
	public Graph getLabyrinth() {
		return labyrinth;
	}
}
