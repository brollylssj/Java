package com.tomaszhanusiak.postac;

public class Paladyn extends Postac implements Stats{

	public Paladyn(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	public Paladyn() {
		setStats();
		setMaxHp();
	}

	/**
	 * Metoda ustawiajaca statystki postaci
	 */
	public void setStats()
	{
		setHp(150);
		setAbilityPower(10);
		setPoziom(1);
		setSila(40);
		setZrecznosc(10);
	}

	@Override
	public String toString() {
		return 
				"\n Klasa Paladyn"+ "\n Twoj poziom " + getPoziom()
				+ "\n Sila " + getSila() + "\n zrecznosc"
				+ getZrecznosc() + "\n HP " + getHp() + "\n Mana "
				+ getAbilityPower();
	}

	@Override
	public void setMaxHp() {
		// TODO Auto-generated method stub
		setHpMax(150);
		
	}
	
	
	@Override
	public void rozdaj() {
		// TODO Auto-generated method stub
		super.rozdaj();
		setSila(getSila()+5);
		setHpMax(getHpMax()+20);
		setZrecznosc(getZrecznosc()+5);
	}

}

