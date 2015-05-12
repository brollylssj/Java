package com.tomaszhanusiak.walka;

import java.util.Random;

import com.tomaszhanusiak.postac.Postac;

public class Dmg {
	
	private int zadawane;
	private int dodge;
	


	public int getZadawane() {
		return zadawane;
	}

	public void setZadawane(int zadawane) {
		this.zadawane = zadawane;
	}

	public int getDodge() {
		return dodge;
	}

	public void setDodge(int speed) {
		this.dodge = speed;
	}

	/**
	 * Metoda liczaca atak bohatera
	 * @param postac obiekt klasy Postac
	 */
	public int physically(Postac postac)
	{
		zadawane = postac.getSila()/5 + postac.getZrecznosc()/8;
		System.out.println("zadane obrazenia fizyczne : "+zadawane );
		return zadawane;
	}
	/**
	 * Meoda zliczajaca atak
	 * @param postac obiekt klasy Postac
	 */
	public int magic(Postac postac)
	{
		zadawane = postac.getAbilityPower()/3;
		System.out.println("zadane obrazenia magiczne : "+zadawane );
		return zadawane;
	}
	/**
	 * Metoda pozwalajaca na unik ataku
	 * @param postac obiekt klasy Postac
	 */
	public boolean dodgeChance(Postac postac)
	{
		dodge= postac.getZrecznosc();
		Random random = new Random();
		
		if(dodge<=100)
		{
			int chance =random.nextInt(100);
			if(chance<=10)
			{
				System.out.println("Uniknieto ataku!");
				return true;
			}
		}
		else if(dodge>100 && dodge<=200)
		{
			int chance =random.nextInt(100);
			if(chance<=25)
			{
				System.out.println("Uniknieto ataku!");
				return true;
			}
		}
		else
		{
			int chance =random.nextInt(100);
			if(chance<=40)
			{
				System.out.println("Uniknieto ataku!");
				return true;
			}
		}
		
		return false;
		
	}
	

	

}
