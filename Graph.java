import java.util.*;

/**
 * Implementiert einen Graphen, der Knoten und alle Nachbarn der Knoten speichert
 */
public class Graph {
	//Attribute
	private List<Knoten> knoten = new ArrayList<>();
	private Map<Knoten,List<Knoten>> nachbarKnoten = new HashMap<Knoten,List<Knoten>>();

	//Konstruktor
	//public Graph() {
	//}

	/**
	 * fügt einen Knoten der Knotenliste hinzu
	 * @param k Knoten, welcher hinzugefügt werden soll
	 */
	public void addKnoten(Knoten k) {
		knoten.add(k);
	}
	/**
	 * Getter
	 * @return gibt die nachbarKnoten Liste zurück
	 */
	public Map<Knoten,List<Knoten>> getNachbarKnoten(){
		return nachbarKnoten;
	}
	/**
	 * Getter für eine Liste aller Nachbarn eines Knoten
	 * @param knoten Knoten, dessen Nachbarn ausgegeben werden sollen
	 * @return gibt die Nachbarn eines Knoten zurück
	 */
	public List<Knoten> getNachbarn(Knoten knoten) {
		return nachbarKnoten.get(knoten);
	}
	/**
	 * Fügt einen Nachbar der Liste der Nachbarn eines Knoten hinzu
	 * @param knoten1 Knoten, dessen Nachbar hinzugefügt wird
	 * @param knoten2 Knoten, welcher als Nachbar von knoten1 hinzugefügt wird
	 */
	public void addNachbar(Knoten knoten1, Knoten knoten2) {
		nachbarKnoten.get(knoten1).add(knoten2);
	}
	/**
	 * Getter
	 * @return Gibt Liste aller Knoten zurück
	 */
	public List<Knoten> getKnoten(){
		return knoten;
	}
}
