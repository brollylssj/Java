package losowanie;

/**
 * 
 * @author Tomasz Hanusiak
 * Klasa glowna programu
 *
 */
public class Test {

	/**
	  * Statyczna metoda main
	  * @param args przyjmuje argumenty podane z linii wywo³ania programu
	  * Wyswietla wynik w kolejnosci alfebetycznej ciag znakow oraz liczy samogloski
	  * i wspolgloski wystepujace
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Losowanie losowanie = new Losowanie();
		
		losowanie.wypelnij();
		System.out.println("wylosowane znaki");
		losowanie.convert();
		losowanie.sortuj();
		System.out.println("\nPo uporzatkowaniu:");
		losowanie.convert();
		losowanie.licz();

	}

}
