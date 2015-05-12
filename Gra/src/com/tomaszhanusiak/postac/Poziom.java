package com.tomaszhanusiak.postac;

import com.tomaszhanusiak.opponent.Opponent;
import com.tomaszhanusiak.walka.Fight;

/**
 * Klasa obrazujaca poziomy bohatera
 * @author Tomasz Hanusiak
 *
 */
public class Poziom extends ProgressLevel {
	
	private int experience;
	
	public int getExperience() {
		return experience;
	}
	public void setExperience(int experience) {
		this.experience = experience;
	}
	
	/**
	 * Metoda sprawdzajaca poziom postaci
	 * @param postac obiekt klasy Postac
	 */
	public void checkLvl(Postac postac)
	{
			System.out.println("Twoj poziom to"+postac.getPoziom());
		
	}
	/**
	 * Metoda zwiekszajaca poziom bohatera
	 * @param postac obiekt klasy Postac
	 */
	public void upgrateLvl(Postac postac)
	{
		postac.setPoziom(postac.getPoziom()+1);
		System.out.println("Osiagnales wyzszy Poziom! \n Twoj aktualny poziom to :"+postac.getPoziom());
		postac.rozdaj();
	}
	
	public void chceckProgress(Postac postac,Fight fight,Opponent opponent)
	{
		if(fight.getPokonany()!=0)
		{
			gainExperience(opponent,postac);
			progress(postac);
		}
		else
			progress(postac);
	}
	@Override
	void progress(Postac postac) {
		System.out.println("Masz "+experience+ " puntow doswiadczenia");
		int dana = lvlUp - getExperience();
		if(dana>0)
		System.out.println("Do kolejnego poziomu brakuje Ci " + dana +" punktow doswiadczenia");
		if(dana <= 0)
		{
			upgrateLvl(postac);
			lvlUp = lvlUp*2*postac.getPoziom();
		}
	}
	@Override
	void gainExperience(Opponent opponent,Postac postac) {
		// TODO Auto-generated method stubp
		
	//int totalExperience = experience + opponent.getPoziomTrudnosci()*10;
		int dodatkowe;
	if(opponent.getPoziomTrudnosci()- postac.getPoziom()>0)
		dodatkowe =opponent.getPoziomTrudnosci()- postac.getPoziom();
	else
		dodatkowe=1;
	setExperience(getExperience() + opponent.getPoziomTrudnosci()*10*dodatkowe);
		
	}

}
