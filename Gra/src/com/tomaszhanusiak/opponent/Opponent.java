package com.tomaszhanusiak.opponent;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

import com.tomaszhanusiak.postac.Postac;

/**
 * Klasa realizujaca opponenta
 * @author Tomasz Hanusiak
 *
 */
public class Opponent extends Postac {
	

	private int poziomTrudnosci;
	private HashMap<Integer, Opponent> map = new HashMap<>();
	
	public Opponent()
	{
		
	}
	
	public Opponent(String name, int sila, int zrecznosc, int hp, int mana,
			int poziomTrudnosci) {
		setName(name);
		setSila(sila);
		setZrecznosc(zrecznosc);
		setHp(hp);
		setAbilityPower(mana);
		this.poziomTrudnosci = poziomTrudnosci;
	}
	
	/**
	 * Metoda ustawiajaca opponentow
	 */
	public void setMonster()
	{
		Opponent opponent = new Opponent("Chlop z Widlami", 10, 10, 20, 0, 1);
		Opponent opponent1 = new Opponent("Staznik bydla", 10, 10, 20, 20, 2);
		Opponent opponent2 = new Opponent("Pikinier", 50, 50, 20, 0, 3);
		Opponent opponent3 = new Opponent("Topornik", 60, 10, 20, 0, 4);
		Opponent opponent4 = new Opponent("Lekki Kawalezysta", 100, 30, 200, 30, 5);
		Opponent opponent5 = new Opponent("Rycerz", 300, 50, 110, 0, 6);
		Opponent opponent6 = new Opponent("Admiral", 500, 50, 500, 0, 7);
		Opponent opponent7 = new Opponent("General", 500, 700, 400, 0, 8);
		Opponent opponent8 = new Opponent("Namiestnik", 800, 800, 800, 200, 9);
		Opponent opponent9 = new Opponent("Krol", 1000, 1000, 200, 300, 10);
		
		map.put(1, opponent);
		map.put(2, opponent1);
		map.put(3, opponent2);
		map.put(4, opponent3);
		map.put(5, opponent4);
		map.put(6, opponent5);
		map.put(7, opponent6);
		map.put(8, opponent7);
		map.put(9, opponent8);
		map.put(10, opponent9);	
		
	}
	
	/**
	 * Metoda pokazujaca opponenty z ktorymi mozna walczyc
	 */
	public void show()
	{
		setMonster();
		
		System.out.println("Przeciwnicy z którymi mozesz walczyc:");
		for (int i = 1; i < map.size()+1; i++) {
			System.out.println(i+". "+map.get(i));
			
		}
	}
	public Opponent selectMonster()
	{
		boolean syntaxError=false;
		do{
			
			try {
				System.out.println("Wprowadz numer:");
				syntaxError=false;
				Scanner scanner = new Scanner(System.in);
				int answer = scanner.nextInt();
				System.out.println("Wybrales przeciwnika "+map.get(answer));
				return map.get(answer);
				
			
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Wpisz 1,2,3...");
				syntaxError=true;
				return null;

			}
			
			
		}while(syntaxError);
		
	}
	public int getPoziomTrudnosci() {
		return poziomTrudnosci;
	}
	public void setPoziomTrudnosci(int poziomTrudnosci) {
		this.poziomTrudnosci = poziomTrudnosci;
	}
	@Override
	public String toString() {
		return  getName() + " na " + poziomTrudnosci
				+ " poziomie trudnosci.";
	}
	
	
	
	
	

}
