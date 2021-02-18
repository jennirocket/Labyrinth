/**
 * Eine Instanz von Knoten wird immer eine eindeutige Nummer zugeordnet
 */

public class Knoten {
	//Variables

	/**
	 * Die Nummer eines Knotens, notwendig für Vergleichszwecke und Wegsuche
	 */
	private String nummer;
	
	/**
	 * Erstellt eine neue Instanz von Knoten
	 * @param nummer Die eindeutige Nummer dieser Instanz von Knoten
	 */
	public Knoten(String nummer) {
		this.nummer = nummer;
	}
	
	/**
	 * Überschreibt die toString Methode, um Nummer eines Knotens auszugeben
	 * @return Nummer eines Knotens
	 */
	@Override
	public String toString() {
		return nummer;
	}
	
	/**
	 * Überschreibt die equals() Methode der Java Klasse Object
	 * Vergleicht Instanzen von Knoten anhand deren eindeutiger Nummern
	 */
	@Override
	public boolean equals(Object o) {
		if(o == this) {
			return true;
		}
		if(o == null || !(o instanceof Knoten)) {
			return false;
		}
		Knoten v = (Knoten) o;
		return this.nummer.equals(v.getNummer());
	}
	
	/**
	 * Überschreibt die hashCode() Methode der Java Klasse Object
	 * Gibt die Nummer des betrachteten Knotens als Hash Code zurück
	 * @return	gibt die Nummer dieses Knotens zurück
	 */
	@Override
	public int hashCode() {
		return Integer.parseInt(nummer);
	}
	
	/**
	 * Getter für Nummer
	 * @return gibt die Nummer dieses Knotens zurück
	 */
	public String getNummer() {
		return nummer;
	}
}
