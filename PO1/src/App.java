/**
 * Klasa glowna programu
 * @author Brolly
 *
 */
 class App {
	 /**
	  * Statyczna metoda main
	  * @param args przyjmuje argumenty podane z linii wywo³ania programu
	  * Wyswietla wynik wyrazenia oraz przeksztalcenie wyrazenia na ONP
	  */
 public static void main(String args[]) {

 String expression = "(7+3)*(5-12)^2=";
  ONP onp = new ONP(expression);
  onp.makeONP();
  System.out.println("Postac ONP:"+ onp.getExpression());
  System.out.println("Wynik wyrazenia "+onp.oblicz());
 }
}