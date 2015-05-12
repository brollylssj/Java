package com.tomaszhanusiak.walka;

import java.util.HashMap;
import java.util.Scanner;

import com.tomaszhanusiak.opponent.Opponent;
import com.tomaszhanusiak.postac.Postac;
import com.tomaszhanusiak.postac.Poziom;

public class Fight {
	
	private int pokonany;
	HashMap<Integer, String> attackMap = new HashMap<>();
	
	public Fight()
	{
		pokonany =0;
		attackMap.put(1, "Fizyczny");
		attackMap.put(2, "Magiczny");
	}
	
	
	public void showAttack()
	{
		for(int i =1;i<attackMap.size()+1;i++)
			System.out.println(i+" "+attackMap.get(i));
	}
	public int getPokonany() {
		return pokonany;
	}
	public void setPokonany(int pokonany) {
		this.pokonany = pokonany;
	}
	/**
	 * Metoda wybierajaca atak;
	 * @param dmg
	 * @param postac
	 */
	public void selectAtack(Postac postac,Opponent opponent)
	{
		boolean syntaxError=false;
		do{
		System.out.println("Wybierz atak");
		showAttack();
			
			try {
				syntaxError=false;
				Scanner scanner = new Scanner(System.in);
				int answer = scanner.nextInt();
				wyprowadz(postac, opponent, answer);
				
			
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Zle wybrany atak");
				syntaxError=true;

			}
			
			
		}while(syntaxError);

	}
	/**
	 * Metoda wyprowadzajaca ataki
	 * @param postac
	 * @param opponent
	 * @param answer
	 */
	public void wyprowadz(Postac postac,Opponent opponent,int answer)
	{
		Dmg dmg = new Dmg();
		if(answer==1)
		{
			if(dmg.dodgeChance(opponent));
			else
			opponent.setHp(opponent.getHp()-dmg.physically(postac));
		}
			
		else if(answer==2)
		{
			if(dmg.dodgeChance(opponent));
			else
			opponent.setHp(opponent.getHp()-dmg.magic(postac));
		}
			
		else
		{
			throw new IllegalArgumentException("Zle wybrany atak");
		}
	}

	/**
	 * Atak opponenta
	 * @param postac
	 * @param opponent
	 */
	public void opponentAttack(Postac postac,Opponent opponent)
	{
		Dmg dmg = new Dmg();
		int attack1= dmg.physically(opponent);
		int attack2= dmg.magic(opponent);
		if(dmg.dodgeChance(postac));
		else
		{
			if(attack1>=attack2)
				postac.setHp(postac.getHp()-attack1);
			else
				postac.setHp(postac.getHp()-attack2);
		}
	}
	
	public void showHP(Postac postac,Opponent opponent)
	{
		if(postac.getHp()<=0)
			System.out.println("Twoje HP: 0!");
		else
		System.out.println("Twoje HP:" +postac.getHp());
		if(opponent.getHp()<=0)
			System.out.println("HP Opponenta: 0!");
		else
		System.out.println("HP Opponenta:" +opponent.getHp());
	}
	/**
	 * Metoda symulujaca trwajaca walke
	 * @param postac
	 * @param opponent
	 */
	public void combat(Postac postac,Opponent opponent)
	{
		if(postac.getHp()<=0)
			System.out.println("Odwiedz Fonntanne zdrowia");
		else
		{
		System.out.println("Prepare to battle...");
		showHP(postac, opponent);
		do{
		System.out.println("\nTwoja tura");
		selectAtack(postac, opponent);
		showHP(postac, opponent);
		if(opponent.getHp()<=0)
			break;
		System.out.println("\nTura Opponenta");
		opponentAttack(postac, opponent);
		showHP(postac, opponent);
		opponent.getHp();
		postac.getHp();
		}while(opponent.getHp()>0 && postac.getHp()>0);
		
		if(opponent.getHp()<=0)
		{
			System.out.println("Zwyciezyles "+opponent);
			pokonany= opponent.getPoziomTrudnosci();
		}
		else
		{
			System.out.println("Zostales pokonany przez "+opponent);
			pokonany= 0;
		}
		}
		
		
	}

}
