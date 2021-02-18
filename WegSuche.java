import java.util.*;

/**
 * Findet alle Wege vom gegebenen Startknoten zum gegebenen Zielknoten für einen beliebigen Graphen.
 * Dies wird durch einen rekursiven Aufruf des DFS (Depth-First_Search) Algorithmus erreicht.
 * Wege werden als diese erkannt, solange sie kreisfrei sind, also während der Traversierung kein Knoten doppelt besucht wird.
 */
public class WegSuche {
	//Attribute
	/**
	 * Liste aller (kreisfreien) Wege vom Start- zum Zielknoten
	 */
	private List<Weg> wege;
	/**
	 * Liste aller besuchten Knoten
	 */
	private List<Knoten> besuchteKnoten;
	/**
	 * Knoten, welcher der Startpunkt und erster Knoten eines möglichen Weges ist
	 */
	private Knoten start;
	/**
	 * Knoten, welcher der Endpunkt und letzter Knoten eines möglichen Weges ist
	 */
	private Knoten ziel;
	/**
	 * Der Graph, welcher durchsucht werden soll (unser "Labyrinth")
	 */
	private Graph graph;

	/**
	 * Initialisiert eine neue Instanz von WegSuche
	 * @param graph Der Graph, welcher durchsucht werden soll
	 * @param start Knoten, welcher der Startpunkt und erster Knoten eines möglichen Weges ist
	 * @param ziel  Knoten, welcher der Endpunkt und letzter Knoten eines möglichen Weges ist
	 */
	public WegSuche(Graph graph, Knoten start, Knoten ziel) {
		this.graph = graph;
		this.start = start;
		this.ziel = ziel;
		besuchteKnoten = new ArrayList<Knoten>();
		wege = new ArrayList<Weg>();
		checkGültigkeit();
		depthFirstSearch(start);
	}

	/**
	 * Getter für Wege
	 * @return Eine Liste aller besuchten Knoten, die während der Suche ständig aktualisiert wird
	 */
	public List<Weg> getWege() {
		return wege;
	}

	/**
	 * Prüft, ob der aktuelle Knoten der Zielknoten des Labyrinths ist und aktualisiert gegebenfalls wege Liste
	 *
	 * @param knoten Der aktuell betrachtete Knoten
	 * @return Gibt true zurück, wenn der aktuelle Knoten Zielknoten ist, anderfalls false.
	 */
	private boolean zielErreicht(Knoten knoten) {
		if (knoten.equals(ziel)) {
			wege.add(new Weg(besuchteKnoten));
			return true;
		} else
			return false;
	}

	/**
	 * Prüft, ob der zu durchsuchende Graph die angegebenen Start- und Zielknoten überhaupt enthält, indem er die getKnoten() Methode
	 * der Klasse Graph aufruft. Falls diese nicht in der, von der Getter Methode übergebenen Liste enthalten sind,
	 * gibt die checkGültigkeit() Methode einen Fehler zurück und terminiert das Programm.
	 */
	private void checkGültigkeit() {
		if (!graph.getKnoten().contains(start) || !graph.getKnoten().contains(ziel)) {
			System.err.println("Keine gültigen Start- und/oder Zielknoten gefunden.");
			System.exit(1);
		}
	}
	/**
	 * Findet rekursiv alle Wege vom Start zum Ziel indem jeder Teilgraph durchsucht wird
	 * 1. Fügt die Wurzel des aktuellen Teilgraphs der besuchteKnoten Liste hinzu
	 * 2. Wenn die Wurzel des aktuellen Teilgraphen dem Ziel entspricht, dann wurde ein Weg gefunden und wird der wege Liste hinzugefügt
	 * 3. Für jeden Nachbarn, welcher noch unbesucht ist, ruft sich die Funktion selbst auf mit diesem Nachbarn als die Wurzel des Teilgraphen
	 * 5. Entfernt die Wurzel des aktuellen Teilgraphen von der besuchtenKnoten Liste
	 *
	 * @param wurzel Die Wurzel des aktuellen Teilgraphen
	 *                (Während des ersten Aufrufs entspricht der Teilgraph dem gesamten Graphen.)
	 */
	private void depthFirstSearch(Knoten wurzel) {
		besuchteKnoten.add(wurzel);
		if (!zielErreicht(wurzel)) {
			for (Knoten i : graph.getNachbarn(wurzel)) {
				if (!besuchteKnoten.contains(i))
					depthFirstSearch(i);
			}
		}
		besuchteKnoten.remove(wurzel);
	}

	/**
	 * toString Methode, um Wege auszugeben
	 * @return String, der alle Wege für diesen Grpahen ausgibt
	 */
	public String toString() {
		StringBuffer wegeAusgeben = new StringBuffer();
		wegeAusgeben.append(wege.size() + " Weg(e) gefunden für " + start + " nach " + ziel + ": \n");
		for (Weg i : wege)
			wegeAusgeben.append(i.toString() + "\n");
		return wegeAusgeben.toString();
	}
}
