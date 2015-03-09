import java.util.Scanner;

public class TestONP {
 public static void main(String args[]) {

  Scanner input = new Scanner(System.in);
  System.out.print ("Podaj wyrażenie: " );
  
  // pobieramy od użytkownika wyrażenie
  String expression = input.nextLine();

  // tworzymy nowy obiekt klasy OdwrotnaNotacjaPolska 
  // i przekazujemy do konstruktora pobrane od użytkownika wyrażenie
  ONP onp = new ONP(expression);
  System.out.println(onp.getWynik());
  System.out.println("Postac ONP:"+ onp.getExpression());
 }
}