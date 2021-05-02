import java.io.Serializable;

/**
 * Lokalika v herním svìtì
 * @author Alena Reichlova
 * @version 1.0
 */
public class Lokalita implements Serializable{
	/**
	 * Název herní lokality
	 */
	private String nazev;
	/**
	 * Èislo herní lokality, žádné dvì lokality ve høe nemají stejné èíslo 
	 * Poznámka: pokud budete používat testovací soubor mapa.csv s mojí mapou, berete jako id lokality i hodnotu 0
	 * -1 je pak vyhrazena pro neexistující lokalitu. Mùžete samozøejmì volit jiný pøístup
	 */
	private int id;
	/**
	 * id sousední lokality, pokud bude id lokality -1, znamená to, že lokalita neexistuje a tímto smìrem se jít nedá
	 * 0 - Sever, 
	 * 1 - Východ, 
	 * 2 - Jih, 
	 * 3 - Západ
	 */
	int[] smery = new int[4]; 
	
	/**
	 * Konstruktor pro vytvoøení nové lokality
	 * @param nazev název lokality
	 * @param id identifikaèní èíslo lokality
	 */
	public Lokalita(String nazev, int id){
		this.nazev = nazev;
		this.id = id;
	}
	
	/**
	 * Metoda, která pøipojí lokalitu v zadaném svìtovém smìru
	 * @param smer èíslo svìtové strany (0 - Sever, 1 - Východ, 2 - Jih, 3 - Západ)
	 * @param kam id lokality
	 */
	public void pripojLokalitu(int smer, int kam) {    
		smery[smer] = kam;
	}    
	
	/**
	 * Metoda vrací název lokality
	 */
	public String toString() {
		return nazev;
	}

	/**
	 * Metoda vrací id lokality
	 * @return id lokality
	 */
	public int getId() {
		return id;
	}

	/**
	 * Zmìna id lokality
	 * @param id nové id lokality
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * Vrací id lokality v zadaném smìru 
	 * @param smer èíslo svìtové strany (0 - Sever, 1 - Východ, 2 - Jih, 3 - Západ)
	 * @return id lokality
	 */
	public int getSmer(int smer) { 
		return smery[smer];
	}
}
