package com.tomaszhanusiak.postac;
/**
 * Klasa 
 * @author Tomasz Hanusiak wytwarzajaca obiekty
 *
 */
public class FactoryPostac {


	/**
	 * Metoda tworzaca profesje postaci
	 * @param postacType -enum z Profesjami	
	 * @return zwraca obiekt wybranej profesji
	 */
	public static Postac createProfession(int answer)
	{
		
		
		switch (answer) {
		case 1:
 
			return new Assassin();
		case 2:
			
			return new Lucznik();
		case 3:
			
			return new Mag();
		case 4:
			
			return new Paladyn();
		

		}throw new IllegalArgumentException("zla nazwa klasy");
		

	

	}
}
