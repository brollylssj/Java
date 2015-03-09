import java.util.Stack;
import java.util.StringTokenizer;


/**
 * ONP
 * @author Tomasz Hanusiak
 */
public class ONP 
{

 private String input; // wyrazenie wprowadzone przez nas
 private String expression; // rozpatrywane wyra�enie
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
  * metoda zdeklaruj�ca priorytet operatora
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
  // dzielimy wyra�enie na cz�ci na podstawie +-*/()#%^
  StringTokenizer piece = new StringTokenizer(input, "+-*/()#%^", true);

  while(piece.hasMoreTokens()) {
   // pobieramy element
   String nextCharacter = piece.nextToken();
         
   // je�eli element jest operatorem
   if( nextCharacter.equals("+") || nextCharacter.equals("*") || nextCharacter.equals("-") || nextCharacter.equals("/") 
	 ||nextCharacter.equals("^") || nextCharacter.equals("#") || nextCharacter.equals("%") ) 
   {
    // sprawdzamy priorytety
    while(!stos.isEmpty() && priorytet(stos.lookAtTop()) >= priorytet(nextCharacter)) 
     expression += stos.pop()  + " ";
    // odk�adamy operator na stos
    stos.push(nextCharacter);
   }
   // je�eli element jest nawiasem otwieraj�cym
   else if(nextCharacter.equals("(")) stos.push(nextCharacter);
   // je�eli element jest nawiasem zamykaj�cym
   else if(nextCharacter.equals(")")) {
    // �ci�gamy operatory ze stosu, a� do nawiasu otwieraj�cego
    while(!stos.lookAtTop().equals("(")) expression += stos.pop() + " ";
    // �ci�gamy nawias otwieraj�cy
    stos.pop();
   }
   // je�eli element jest liczba dodajemy go do wyrazenia
   else expression += nextCharacter  + " ";
  }
  // �ci�gamy ze stosu pozosta�e operatory i dodajemy je do wyra�enia
  while(!stos.isEmpty()) expression += stos.pop()  + " ";
        
 } 

/**
 * metoda
 */
 // metoda oblicza warto�� wyra�enia postfiksowego
 private double oblicz() {
  
 // Stack<Double> stos = new Stack<Double>();
	 Stos stosDouble = new Stos(256,"double"); // tworzymy stos
  // dzielimy wyra�enie postfiksowe na elementy na podstawie spacji
  StringTokenizer share = new StringTokenizer(expression, " ");
        
  // dop�ki s� elementy w wyra�eniu wej�ciowym
  while(share.hasMoreTokens()) {

   // pobieramy element
   String element = share.nextToken();
  
   // je�li element nie jest operatorem (czyli jest warto�ci�)
   if (!element.equals("+") && !element.equals(")")&&!element.equals("(") && !element.equals("*") && !element.equals("-") && !element.equals("/") && !element.equals("%")&& !element.equals("^") && !element.equals("#") ) {
    // zamieniamy �a�cuch na liczb�
    double wartosc = Double.parseDouble(element);
    // odk�adamy warto�� na stos
    stosDouble.pushDouble(wartosc);
   }
   else 
   {
    //  je�li element jest operatorem �ci�gamy dwie warto�ci ze stosu
    double wartosc1 = stosDouble.popDouble();
    double wartosc2 = stosDouble.popDouble();
    // w zale�no�ci od operatora obliczamy wynik i odk�adamy go na stos
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