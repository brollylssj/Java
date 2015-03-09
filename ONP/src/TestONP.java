import java.util.Scanner;

public class TestONP {
 public static void main(String args[]) {

  Scanner input = new Scanner(System.in);
  System.out.print ("Podaj wyra¿enie: " );
  
  // pobieramy od u¿ytkownika wyra¿enie
  String expression = input.nextLine();

  // tworzymy nowy obiekt klasy OdwrotnaNotacjaPolska 
  // i przekazujemy do konstruktora pobrane od u¿ytkownika wyra¿enie
  ONP onp = new ONP(expression);
  System.out.println(onp.getWynik());

 }
}