import java.util.Stack;
import java.util.StringTokenizer;


/**
 * ONP
 * @author Tomasz Hanusiak
 */
public class ONP 
{

 private String input; // wyrazenie wprowadzone przez nas
 private String expression; // rozpatrywane wyra¿enie
 private double result;   // wynik ONP

 
 public String getInput() {
		return input;
	}

	public String getExpression() {
		return expression;
	}
 
 
 
/**
 * metoda zwracajaca wynik
 * @return zwraca wynik wyrazenia
 */
 public double getWynik() 
{
	return result;
}

 public ONP(String input)
 {
  this.input = input;
  expression = "";
  result = 0.0;
  makeONP();
  result = oblicz();
 }   

 
 /**
  * metoda zdeklaruj¹ca priorytet operatora
  *@param operator zwraca priorytet operatora
  */
 public int priorytet(String operator) {
  if(operator.equals("+") || operator.equals("-")) return 1;
  else if(operator.equals("*") || operator.equals("/") ||  operator.equals("%") ) return 2;
  else if(operator.equals("^") || operator.equals("#")) return 3;
  else return 0;
 }
 
 /**
  * metoda obliczajaca
  */
public void makeONP() {
          
  Stos stos = new Stos(256); // tworzymy stos
  // dzielimy wyra¿enie na czêœci na podstawie +-*/()#%^
  StringTokenizer piece = new StringTokenizer(input, "+-*/()#%^", true);

  while(piece.hasMoreTokens()) {
   // pobieramy element
   String nextCharacter = piece.nextToken();
         
   // je¿eli element jest operatorem
   if( nextCharacter.equals("+") || nextCharacter.equals("*") || nextCharacter.equals("-") || nextCharacter.equals("/") 
	 ||nextCharacter.equals("^") || nextCharacter.equals("#") || nextCharacter.equals("%") ) 
   {
    // sprawdzamy priorytety
    while(!stos.isEmpty() && priorytet(stos.lookAtTop()) >= priorytet(nextCharacter)) 
     expression += stos.pop()  + " ";
    // odk³adamy operator na stos
    stos.push(nextCharacter);
   }
   // je¿eli element jest nawiasem otwieraj¹cym
   else if(nextCharacter.equals("(")) stos.push(nextCharacter);
   // je¿eli element jest nawiasem zamykaj¹cym
   else if(nextCharacter.equals(")")) {
    // œci¹gamy operatory ze stosu, a¿ do nawiasu otwierajêcego
    while(!stos.lookAtTop().equals("(")) expression += stos.pop() + " ";
    // œci¹gamy nawias otwieraj¹cy
    stos.pop();
   }
   // je¿eli element jest liczba dodajemy go do wyrazenia
   else expression += nextCharacter  + " ";
  }
  // œci¹gamy ze stosu pozosta³e operatory i dodajemy je do wyra¿enia
  while(!stos.isEmpty()) expression += stos.pop()  + " ";
        
 } 

/**
 * metoda
 */
 // metoda oblicza wartoœæ wyra¿enia postfiksowego
 private double oblicz() {
  
 // Stack<Double> stos = new Stack<Double>();
	 Stos stosDouble = new Stos(256,"double"); // tworzymy stos
  // dzielimy wyra¿enie postfiksowe na elementy na podstawie spacji
  StringTokenizer share = new StringTokenizer(expression, " ");
        
  // dopóki s¹ elementy w wyra¿eniu wejœciowym
  while(share.hasMoreTokens()) {

   // pobieramy element
   String element = share.nextToken();
  
   // jeœli element nie jest operatorem (czyli jest wartoœci¹)
   if (!element.equals("+") && !element.equals(")")&&!element.equals("(") && !element.equals("*") && !element.equals("-") && !element.equals("/") && !element.equals("%")&& !element.equals("^") && !element.equals("#") ) {
    // zamieniamy ³añcuch na liczbê
    double wartosc = Double.parseDouble(element);
    // odk³adamy wartoœæ na stos
    stosDouble.pushDouble(wartosc);
   }
   else 
   {
    //  jeœli element jest operatorem œci¹gamy dwie wartoœci ze stosu
    double wartosc1 = stosDouble.popDouble();
    double wartosc2 = stosDouble.popDouble();
    // w zale¿noœci od operatora obliczamy wynik i odk³adamy go na stos
    switch(element.charAt(0)) { 		// charAt bierze z pierwszego miejsca znak i sprawdza jakie dzialanie wykonac
     case '*': {stosDouble.pushDouble(wartosc2 * wartosc1); break;}
     case '+': {stosDouble.pushDouble(wartosc2 + wartosc1); break;}
     case '-': {stosDouble.pushDouble(wartosc2 - wartosc1); break;}
     case '/': {stosDouble.pushDouble(wartosc2 / wartosc1); break;}
     case '%': {stosDouble.pushDouble(wartosc2 % wartosc1); break;}
     case '#': {stosDouble.pushDouble(Math.exp(Math.log(wartosc1))/wartosc2); break;}// pierwiastek wartosc2 -stopnia z warosc1
     case '^': {stosDouble.pushDouble(Math.pow(wartosc2,wartosc1)); break;} 
     
    }
   }
  }
  return stosDouble.popDouble();
 }
 
}