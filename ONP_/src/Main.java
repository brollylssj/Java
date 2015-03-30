import java.util.Scanner;


public class Main {

	 public static void main(String args[]) {

		  Scanner sc = new Scanner(System.in);
		  System.out.print ("Podaj wyrażenie infiksowe: " );
		  
		  // pobieramy od użytkownika wyrażenie
		  String wyrazenie = sc.nextLine();

		  // tworzymy nowy obiekt klasy OdwrotnaNotacjaPolska 
		  // i przekazujemy do konstruktora pobrane od użytkownika wyrażenie
		  OdwrotnaNotacjaPolska onp = new OdwrotnaNotacjaPolska(wyrazenie);

		  // wyświetlamy wyrażenie w postaci postfiksowej
		  System.out.println ("Wyrażenie postfiksowe: " + onp);
		 }
		}
