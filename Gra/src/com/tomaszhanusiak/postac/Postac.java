package com.tomaszhanusiak.postac;

import java.util.HashMap;
import java.util.Scanner;





import com.tomaszhanusiak.opponent.Opponent;


/**
 * Klasa reprezentujaca postac w grze
 * @author Tomasz Hanusiak
 *
 */
public class Postac{
	
	
	private String name;
	private int sila;
	private int zrecznosc;
	private int hp;
	private int ablityPower;
	private int hpMax;
	private int poziom;
	private Poziom currentPoziom;
	private boolean changeProfession=true;
	private HashMap<Integer, String> mapProfession = new HashMap<Integer, String>();
	
	/**
	 * Konstruktor postaci zwracajacy imie
	 * @param name
	 */
	public Postac(String name) {
		this.name = name;
		

	}
	
	public Postac()
	{
		poziom =1;
		currentPoziom = new Poziom();
		
	}
	/*
	 * Getery i setery ustawiajace atrybuty bohatera
	 * 
	 */
	
	public String getName() {
		return name;
	}
	public Poziom getCurrentPoziom() {
		return currentPoziom;
	}

	public void setCurrentPoziom(Poziom currentPoziom) {
		this.currentPoziom = currentPoziom;
	}

	@Override
	public String toString() {
		return "Stworzyles postac o imieniu " + name ;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPoziom() {
		return poziom;
	}
	public void setPoziom(int poziom) {
		this.poziom = poziom;
	}
	public int getSila() {
		return sila;
	}
	public void setSila(int sila) {
		this.sila = sila;
	}
	public int getZrecznosc() {
		return zrecznosc;
	}
	public void setZrecznosc(int zrecznosc) {
		this.zrecznosc = zrecznosc;
	}
	public int getHp() {
		return hp;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
	public int getAbilityPower() {
		return ablityPower;
	}
	public void setAbilityPower(int mana) {
		this.ablityPower = mana;
	}
	

	public int getHpMax() {
		return hpMax;
	}

	public void setHpMax(int hpMax) {
		this.hpMax = hpMax;
	}


	public boolean isChangeProfession() {
		return changeProfession;
	}

	public void setChangeProfession(boolean changeProfession) {
		this.changeProfession = changeProfession;
	}

	/**
	 * Metoda nadajaca imie bohaterowi
	 */
	public void choseName()
	{
		do{
		System.out.println("Podaj imie bohatera");
		Scanner input = new Scanner(System.in);
		String name = input.nextLine();
		setName(name);
		}while(name.isEmpty());
	}
	

	/**
	 * Sprawdza Stworzenia z ktorymi mozesz walczyc
	 * @param opponent - obiekt klasy opponent
	 */
	public void checkListOfMonster(Opponent opponent)
	{
		opponent.show();
		
	}
	/**
	 * Wybor profesji gracza
	 */
	public Postac selectProfession()
	{
		Postac postac = null;
		if(changeProfession)
		{
		System.out.println("Wybierz profesje która chesz wybrac");
		mapProfession.put(1,"Assasin");
		mapProfession.put(2,"Lucznik");
		mapProfession.put(3,"Mag");
		mapProfession.put(4,"Palladyn");
		
		
		while(true)
		{	
			int answer = checkAnswer();
			try {
				postac =FactoryPostac.createProfession(answer);
			} catch (IllegalArgumentException e) {
				System.out.println("Nieznana profesja wybierz jeszcze raz");
					continue;
			}
				break;
			
		}
		
		
		return postac;
		}
		else
		{
			System.out.println("Wybrales juz profesje");
			return postac;
		}
	}
	/**
	 * Wyswietlanie profesji
	 */
	private void showProfession()
	{
		for (int i = 1; i < mapProfession.size()+1; i++) {
			
			System.out.println(i+" "+mapProfession.get(i));
		}
	}
	
	/**
	 * Sprawdzanie odpowiedzi od urzytkownika
	 */
	public int checkAnswer()
	{	
		boolean syntaxError=false;
		do{
			
			try {
				
				
				
				syntaxError=false;
				showProfession();
				Scanner scanner = new Scanner(System.in);
				int answer = scanner.nextInt();
				return answer;
			
				
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Wpisz 1,2,3...");
				syntaxError=true;
				return 0;
			}
			
			
		}while(syntaxError);

	}

	public void rozdaj() {
		System.out.println("Ulepszono twoje statystki");
		
	}
	
	
	
	
	
	
	
}
