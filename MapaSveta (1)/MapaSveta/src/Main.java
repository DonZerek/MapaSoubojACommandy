import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Testovac� t��da
 * @author Alena
 * @version 1.0
 */
public class Main {

	/**
	 * Lze pou��t pro otestov�n� va�eho k�du s vyu�it�m p�ilo�en�ho souboru s mapou sv�ta
	 * Pokud p�ete vlastn� t��dy m��e testovac� k�d vypadat �pln� jinak
	 * @param args vstupn� prametry pro spu�t�n� z p��kazov� ��dky
	 */
	public static void main(String[] args) {
				try {
					MapaSveta mapa = MapaSveta.nacti("mapa.csv");
					System.out.println("Misto: "+mapa.nazevAktualniPolohy());
					if(!mapa.jdiNa(0)) {
						System.out.println("nelze");
					}
					System.out.println("Misto: "+mapa.nazevAktualniPolohy());
					if(!mapa.jdiNa(3)) {
						System.out.println("nelze");
					}
					System.out.println("Misto: "+mapa.nazevAktualniPolohy());
					if(!mapa.jdiNa(3)) {
						System.out.println("nelze");
					}
					System.out.println("Misto: "+mapa.nazevAktualniPolohy());
					if(!mapa.jdiNa(0)) {
						System.out.println("nelze");
					}
					System.out.println("Misto: "+mapa.nazevAktualniPolohy());
				} catch(FileNotFoundException e) {
					System.out.println("Soubor s mapou hern�ho sv�ta nebyl nalezen.");
				} catch (IOException ex) {
					System.out.println("Nastal probl�m p�i �ten� dat ze souboru.");
				} catch (Exception ex) {
					System.out.println("Data v souboru nep�estavuj� mapu sv�ta.");
					System.out.print("Pokud nen� probl�m s daty v souboru, asi jste p�i programov�n� pokazili");
					System.out.print("je�t� n�co jin�ho.");
				}

	}

}
