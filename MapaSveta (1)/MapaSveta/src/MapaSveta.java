import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;

/**
 * T��da pro ulo�en� mapy hern�ho sv�ta
 * Vyu��v� HashMapu, ve kter� je jako kl�� id lokality a jako hodnota samotn� lokalita
 * @author Alena Reichlov�
 * @version 1.0
 */
public class MapaSveta extends HashMap<Integer, Lokalita> implements Serializable {
	private int zacatek = 7; 
	private int aktualniPoloha = zacatek;
	
	/**
	 * Metoda na�te mapu ze souboru
	 * @param nazevSouboru nazev a cesta k souboru, ve kterem je ulo�ena herni mapa
	 * @return vytvo�en� mapa
	 * @throws IOException v�jimka k jej�mu� vyhozen� dojde, pokud nastane probl�m p�i �ten� ze souboru, 
	 * ve kter�m by m�la b�t ulo�ena hern� mapa
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
	 * Metoda vrac� n�zev aktu�ln� lokality, kde by se hr�� mohl nach�zet
	 * @return n�zev aktu�ln� lokality
	 */
	public String nazevAktualniPolohy() {
		return this.get(aktualniPoloha).toString();
	}
	
	/**
	 * Metoda nastav� novou aktu�ln� poloho. P�esune hr��e do nov� lokality podle zadan�ho sm�ru
	 * 0 - Sever, 
	 * 1 - V�chod, 
	 * 2 - Jih, 
	 * 3 - Z�pad
	 * @param smer ud�v� sv�tovou stranu, kam se m� hr�� p�esunout (0 - 3)
	 * @return vraci true/false, pokud je mo�no posunout se po map� zadan�m sm�rem
	 */
	public boolean jdiNa(int smer) {
		int idKam = this.get(aktualniPoloha).getSmer(smer);
		if(idKam == -1) {return false;}
		aktualniPoloha = idKam;
		return true;
	}

}
