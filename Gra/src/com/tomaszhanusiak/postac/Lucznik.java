package com.tomaszhanusiak.postac;

public class Lucznik extends Postac implements Stats{

	public Lucznik(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	public Lucznik() {
		// TODO Auto-generated constructor stub
		setStats();
		setMaxHp();
	}
	
	
	/**
	 * Metoda ustawiajaca statystki postaci
	 */
	public void setStats()
	{
		setHp(80);
		setAbilityPower(30);
		setPoziom(1);
		setSila(15);
		setZrecznosc(50);
	}

	@Override
	public String toString() {
		return 
				"\n Klasa Lucznik"+ "\n Twoj poziom " + getPoziom()
				+ "\n Sila " + getSila() + "\n zrecznosc"
				+ getZrecznosc() + "\n HP " + getHp() + "\n Mana "
				+ getAbilityPower();
	}

	@Override
	public void setMaxHp() {
		setHpMax(80);
		
	}
	
	
	@Override
	public void rozdaj() {
		// TODO Auto-generated method stub
		
		super.rozdaj();
		setSila(getSila()+5);
		setHpMax(getHpMax()+10);
		setZrecznosc(getZrecznosc()+25);
	}
	
	


}

