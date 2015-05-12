package com.tomaszhanusiak.postac;
/**
 * Klasa odpowiadajaca za reprezentacje postaci Assassin
 * @author Tomasz Hanusiak
 *
 */
public class Assassin extends Postac implements Stats{

	public Assassin(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
		
		public Assassin()
		{
			setStats();
			setMaxHp();
		}
		
		/**
		 * Metoda ustawiajaca statystki postaci
		 */
		public void setStats()
		{
			setHp(100);
			setAbilityPower(20);
			setPoziom(1);
			setSila(20);
			setZrecznosc(40);
		}

		@Override
		public String toString() {
			return 
					"\n Klasa Assasin"+ "\n Twoj poziom " + getPoziom()
					+ "\n Sila " + getSila() + "\n zrecznosc"
					+ getZrecznosc() + "\n HP " + getHp() + "\n Mana "
					+ getAbilityPower();
		}

		@Override
		public void setMaxHp() {
			setHpMax(100);
		
			
		}

		@Override
		public void rozdaj() {
			// TODO Auto-generated method stub
			
			super.rozdaj();
			setSila(getSila()+10);
			setHpMax(getHpMax()+10);
			setZrecznosc(getZrecznosc()+15);
		}


			
		}
		
		
	


