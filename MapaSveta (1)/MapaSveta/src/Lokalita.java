import java.io.Serializable;

/**
 * Lokalika v hern�m sv�t�
 * @author Alena Reichlova
 * @version 1.0
 */
public class Lokalita implements Serializable{
	/**
	 * N�zev hern� lokality
	 */
	private String nazev;
	/**
	 * �islo hern� lokality, ��dn� dv� lokality ve h�e nemaj� stejn� ��slo 
	 * Pozn�mka: pokud budete pou��vat testovac� soubor mapa.csv s moj� mapou, berete jako id lokality i hodnotu 0
	 * -1 je pak vyhrazena pro neexistuj�c� lokalitu. M��ete samoz�ejm� volit jin� p��stup
	 */
	private int id;
	/**
	 * id sousedn� lokality, pokud bude id lokality -1, znamen� to, �e lokalita neexistuje a t�mto sm�rem se j�t ned�
	 * 0 - Sever, 
	 * 1 - V�chod, 
	 * 2 - Jih, 
	 * 3 - Z�pad
	 */
	int[] smery = new int[4]; 
	
	/**
	 * Konstruktor pro vytvo�en� nov� lokality
	 * @param nazev n�zev lokality
	 * @param id identifika�n� ��slo lokality
	 */
	public Lokalita(String nazev, int id){
		this.nazev = nazev;
		this.id = id;
	}
	
	/**
	 * Metoda, kter� p�ipoj� lokalitu v zadan�m sv�tov�m sm�ru
	 * @param smer ��slo sv�tov� strany (0 - Sever, 1 - V�chod, 2 - Jih, 3 - Z�pad)
	 * @param kam id lokality
	 */
	public void pripojLokalitu(int smer, int kam) {    
		smery[smer] = kam;
	}    
	
	/**
	 * Metoda vrac� n�zev lokality
	 */
	public String toString() {
		return nazev;
	}

	/**
	 * Metoda vrac� id lokality
	 * @return id lokality
	 */
	public int getId() {
		return id;
	}

	/**
	 * Zm�na id lokality
	 * @param id nov� id lokality
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * Vrac� id lokality v zadan�m sm�ru 
	 * @param smer ��slo sv�tov� strany (0 - Sever, 1 - V�chod, 2 - Jih, 3 - Z�pad)
	 * @return id lokality
	 */
	public int getSmer(int smer) { 
		return smery[smer];
	}
}
