import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;

/**
 * Tøída pro uložení mapy herního svìta
 * Využívá HashMapu, ve které je jako klíè id lokality a jako hodnota samotná lokalita
 * @author Alena Reichlová
 * @version 1.0
 */
public class MapaSveta extends HashMap<Integer, Lokalita> implements Serializable {
	private int zacatek = 7; 
	private int aktualniPoloha = zacatek;
	
	/**
	 * Metoda naète mapu ze souboru
	 * @param nazevSouboru nazev a cesta k souboru, ve kterem je uložena herni mapa
	 * @return vytvoøená mapa
	 * @throws IOException výjimka k jejímuž vyhození dojde, pokud nastane problém pøi ètení ze souboru, 
	 * ve kterém by mìla být uložena herní mapa
	 */
	public static MapaSveta nacti(String nazevSouboru) throws IOException {
		MapaSveta mapa = new MapaSveta();
		BufferedReader reader = new BufferedReader(new FileReader(nazevSouboru));
		String radek = "";
		while((radek = reader.readLine())!=null) {
			String[] pole = radek.split(";");
			Lokalita lokalita = new Lokalita(pole[1],Integer.parseInt(pole[0]));
			for(int i = 0; i < 4; i++) {
				lokalita.pripojLokalitu(i, Integer.parseInt(pole[i+2]));
			}
			mapa.put(lokalita.getId(), lokalita);
		}
		reader.close();
		return mapa;
	}
	
	/**
	 * Metoda vrací název aktuální lokality, kde by se hráè mohl nacházet
	 * @return název aktuální lokality
	 */
	public String nazevAktualniPolohy() {
		return this.get(aktualniPoloha).toString();
	}
	
	/**
	 * Metoda nastaví novou aktuální poloho. Pøesune hráèe do nové lokality podle zadaného smìru
	 * 0 - Sever, 
	 * 1 - Východ, 
	 * 2 - Jih, 
	 * 3 - Západ
	 * @param smer udává svìtovou stranu, kam se má hráè pøesunout (0 - 3)
	 * @return vraci true/false, pokud je možno posunout se po mapì zadaným smìrem
	 */
	public boolean jdiNa(int smer) {
		int idKam = this.get(aktualniPoloha).getSmer(smer);
		if(idKam == -1) {return false;}
		aktualniPoloha = idKam;
		return true;
	}

}
