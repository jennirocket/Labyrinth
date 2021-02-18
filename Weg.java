import java.util.*;

/**
 * Speichert eine Wegsuche.
 * Wege werden als diese erkannt, solange sie kreisfrei sind, also während der Traversierung kein Knoten doppelt besucht wird.
 * Wirft Fehler, wenn Versuch ein Weg mit doppelt vorkommenden Knoten hinzuzufügen gemacht wird
 */
public class Weg {
	//Attribute
	private List<Knoten> knoten;
	
	/**
	 * Initialisiert einen neu erstellten Weg
	 * @param knoten Liste der Knoten, welche die Traversierreihenfolge repräsentieren
	 */
	public Weg(List<Knoten> knoten) {
		this.knoten = new ArrayList<Knoten>();
		for (Knoten i: knoten) {
			checkGültigkeit(i);
			this.knoten.add(i);
		}
	}
	
	/**
	 * toString Methode, welche jeden Knoten in einem Weg von Start bis zum Ziel ausgibt
	 * @return Gibt Weg als String zurück
	 */
	public String toString() {
		StringBuffer pathToPrint = new StringBuffer();
		for (Knoten i : knoten)
			pathToPrint.append("," + i.toString());
		return pathToPrint.toString();
	}
	
	/**
	 * Prüft, ob ein Knoten schon einmal im Weg vorhanden ist, wirft Fehler, falls dies zutrifft
	 * @param knoten Zu überprüfende Knoten
	 */
	private void checkGültigkeit(Knoten knoten) {
		if (this.knoten.contains(knoten)) {
			System.err.println("Fehler bei Erstellung eines Weges: Ein Weg darf keine doppelt vorkommenden Knoten enthalten!");
			System.exit(1);
		}
	}
}
