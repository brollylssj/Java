import java.util.Scanner;



public class Kolo 
{
	private double promien;
	
	// robie mutator by pobierac privatne dane z KOla
	// mutuje zmienia wartosc pola
	public void setPromien(double r)
	{
		promien = r;
	}
	
	// akcesor daje acess do danych.
	public double getPromien()
	{
		return promien;
	}
	
	public void obliczObwod()
	{
		System.out.println("Obwod ko³a o promieniu"+ promien+"wynosi "+ 2*Math.PI*promien);
		
	}

	public void obliczPole()
	{
		System.out.println("Pole wynosi " + Math.PI*promien*promien);
	}
	
	
	public static void main(String[] args)
	{
		// tworze obiekt figura klasy ko³o
			Kolo figura = new Kolo();
			
			System.out.println("Podaj promien ko³a");
			Scanner scan = new Scanner(System.in);
			
			figura.promien = scan.nextDouble();
	
			
			figura.obliczObwod();
			figura.obliczPole();
			
			
	}

}
