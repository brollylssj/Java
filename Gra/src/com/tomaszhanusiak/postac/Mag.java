package com.tomaszhanusiak.postac;

public class Mag extends Postac implements Stats{

	public Mag(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	public Mag() {
		setStats();
		setMaxHp();
	}

	/**
	 * Metoda ustawiajaca statystki postaci
	 */
	public void setStats()
	{
		setHp(60);
		setAbilityPower(70);
		setPoziom(1);
		setSila(10);
		setZrecznosc(20);
	}

	@Override
	public String toString() {
		return 
				"\n Klasa Mag"+ "\n Twoj poziom " + getPoziom()
				+ "\n Sila " + getSila() + "\n zrecznosc"
				+ getZrecznosc() + "\n HP " + getHp() + "\n Mana "
				+ getAbilityPower();
	}

	@Override
	public void setMaxHp() {
		// TODO Auto-generated method stub
		
		setHpMax(60);
	
	}
	
	@Override
	public void rozdaj() {
		// TODO Auto-generated method stub
		super.rozdaj();
		setSila(getSila()+5);
		setHpMax(getHpMax()+10);
		setAbilityPower(getAbilityPower()+15);
	}


}

