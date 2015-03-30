import java.util.Stack;
import java.util.StringTokenizer;


/**
 * Klasa zamieniaj¹ca ci¹g znaków na ONP
 * @author Tomasz Hanusiak
 */
public class ONP 
{

 private String input; // wyrazenie wprowadzone przez nas
 private String expression; // rozpatrywane wyra¿enie
 private double result;   // wynik ONP


/**
 * 
 * @return zwraca wyrazenie ONP
 */
	public String getExpression() {
		return expression;
	}
 /**
  * Konstruktor 
  * @param input wprowadzany ciag znakow
  */
 public ONP(String input)
 {
  this.input = input;
  expression = "";
  result = 0.0;
 }   

 
 /**
  * Metoda zdeklaruj¹ca priorytet operatora
  *@param operator znak ktory chcemy sprawdzic priorytet
  *@return zwraca priorytet operatora
  */
 public int priorytet(String operator) 
 {
  if(operator.equals("+") || operator.equals("-")) 
	  return 1;
  else if(operator.equals("*") || operator.equals("/") ) 
	  return 2;
  else if(operator.equals("^")) 
	  return 3;
  
  else return 0;
 }
 
 /**
  * Metoda tworzaca z wyrazenia ONP
  */
public void makeONP() {
          
  StosString stos = new StosString(20); // tworzymy stos
  // dzielimy wyra¿enie na czêœci na podstawie "+-*/()^=" z input
  StringTokenizer piece = new StringTokenizer(input, "+-*/()^=", true);

  // dopoki mamy wiecej elementow
  do
  {
   // pobieramy element
   String nextCharacter = piece.nextToken();
         
   // je¿eli element jest operatorem
   if( nextCharacter.equals("+") || nextCharacter.equals("*") || nextCharacter.equals("-") || nextCharacter.equals("/") 
	 ||nextCharacter.equals("^") || nextCharacter.equals("=")) 
   {
    // sprawdzamy priorytety
    while(!stos.isEmpty() && priorytet(stos.lookAtTop()) >= priorytet(nextCharacter)) 
     expression =expression + stos.pop()  + " ";
    // odk³adamy operator na stos
    stos.push(nextCharacter);
   }
   // je¿eli element jest nawiasem otwieraj¹cym
   else if(nextCharacter.equals("(")) 
	   stos.push(nextCharacter);
   // je¿eli element jest nawiasem zamykaj¹cym
   else if(nextCharacter.equals(")")) 
   {
    // œci¹gamy operatory ze stosu, a¿ do nawiasu otwierajêcego
    while(!stos.lookAtTop().equals("("))
    	expression = expression + stos.pop() + " ";
    // œci¹gamy nawias otwieraj¹cy
    stos.pop();
   }
   
   else if(nextCharacter.equals("="))
	  expression = expression + stos.pop() +" "; 
   
   // je¿eli element jest liczba dodajemy go do wyrazenia
   else
	   expression = expression + nextCharacter  + " ";
   
  }while(piece.hasMoreTokens());
  
  // œci¹gamy ze stosu pozosta³e operatory i dodajemy je do wyra¿enia
  while(!stos.isEmpty()) 
	  expression = expression + stos.pop()  + " ";      
 } 

/**
 * Metoda obliczajaca wyrazenie
 * @return zwraca wynik wyrazenia ze stosu
 */
public double oblicz() 
{
	 StosDouble stosDouble = new StosDouble(20); // tworzymy stos
   //dzielimy wyra¿enie na elementy na podstawie spacji
	 String[] share = expression.split(" ");
  // dopóki s¹ elementy w wyra¿eniu wejœciowym
  for(int i=0; i<share.length;i++)
  {
	  String element= share[i];
   // jesli element jest = zwroc co masz na stosie
	  if(element.equals("="))
	   return stosDouble.popDouble();
   
   // jeœli element nie jest operatorem
   else if (!element.equals("+") && !element.equals("*") && !element.equals("-") && !element.equals("/") && !element.equals("^")) 
   {
    // zamieniamy ³añcuch na liczbê
    double wartosc = Double.parseDouble(element);
    // odk³adamy wartoœæ na stos
    stosDouble.pushDouble(wartosc);
   } 
   else 
   {
    //  jeœli element jest operatorem œci¹gamy dwie wartoœci ze stosu
    double value1 = stosDouble.popDouble();
    double value2 = stosDouble.popDouble();
    
    // w zale¿noœci od operatora obliczamy wynik i odk³adamy go na stos  
    if(element.substring(0).equals("+"))
    	stosDouble.pushDouble(value2 + value1);
    else if(element.substring(0).equals("-"))
    	stosDouble.pushDouble(value2 - value1);
    else if(element.substring(0).equals("*"))
    	stosDouble.pushDouble(value2 * value1);
    else if(element.substring(0).equals("/"))
    	stosDouble.pushDouble(value2 / value1);
    else if(element.substring(0).equals("^"))
    	stosDouble.pushDouble(Math.pow(value2,value1));
    else if(element.substring(0).equals("="))
    	break;
   }
   
  }
  return stosDouble.popDouble();
 }

 
}