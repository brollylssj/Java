import java.util.Scanner;

public class TestONP {
 public static void main(String args[]) {

  Scanner input = new Scanner(System.in);
  System.out.print ("Podaj wyrażenie: " );
  
  // pobieramy od użytkownika wyrażenie
  String expression = input.nextLine();

  ONP onp = new ONP(expression);
  onp.makeONP();
  System.out.println (onp.oblicz());
  System.out.println("Postac ONP:"+ onp.getExpression());
 }
}