import java.util.Scanner;


public class Main {

	 public static void main(String args[]) {

		  Scanner sc = new Scanner(System.in);
		  System.out.print ("Podaj wyra¿enie infiksowe: " );
		  
		  // pobieramy od u¿ytkownika wyra¿enie
		  String wyrazenie = sc.nextLine();

		  // tworzymy nowy obiekt klasy OdwrotnaNotacjaPolska 
		  // i przekazujemy do konstruktora pobrane od u¿ytkownika wyra¿enie
		  OdwrotnaNotacjaPolska onp = new OdwrotnaNotacjaPolska(wyrazenie);

		  // wyœwietlamy wyra¿enie w postaci postfiksowej
		  System.out.println ("Wyra¿enie postfiksowe: " + onp);
		 }
		}
