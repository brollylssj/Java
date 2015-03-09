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
        
  // tworzymy pusty stos
  Stos stos = new Stos(256);
        
  // dzielimy wyra¿enie na czêœci na podstawie +-*/()#%^
  StringTokenizer piece = new StringTokenizer(input, "+-*/()#%^", true);
        
  // dopóki s¹ elementy w wyra¿eniu wejœciowym
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
   // je¿eli element nie jest operatorem ani nawiasem dodajemy go do wyra¿enia postfiksowego
   else expression += nextCharacter  + " ";
  }
  // œci¹gamy ze stosu pozosta³e operatory i dodajemy je do wyra¿enia postfiksowego
  while(!stos.isEmpty()) expression += stos.pop()  + " ";
        
 } 

/**
 * 
 * 
 */
 // metoda oblicza wartoœæ wyra¿enia postfiksowego
 private double oblicz() {
  
  // tworzymy pusty stos
  Stack<Double> stos = new Stack<Double>();
        
  // dzielimy wyra¿enie postfiksowe na elementy na podstawie spacji
  StringTokenizer st = new StringTokenizer(expression, " ");
        
  // dopóki s¹ elementy w wyra¿eniu wejœciowym
  while(st.hasMoreTokens()) {

   // pobieramy element
   String s = st.nextToken();
  
   // jeœli element nie jest operatorem (czyli jest wartoœci¹)
   if (!s.equals("+") && !s.equals("*") && !s.equals("-") && !s.equals("/") && !s.equals("%")&& !s.equals("^") && !s.equals("#") ) {
    // zamieniamy ³añcuch na liczbê
    double wartosc = Double.parseDouble(s);
    // odk³adamy wartoœæ na stos
    stos.push(wartosc);
   }
   else 
   {
    //  jeœli element jest operatorem œci¹gamy dwie wartoœci ze stosu
    double wartosc1 = stos.pop();
    double wartosc2 = stos.pop();
    // w zale¿noœci od operatora obliczamy wynik i odk³adamy go na stos
    switch(s.charAt(0)) {
     case '*': {stos.push(wartosc2 * wartosc1); break;}
     case '+': {stos.push(wartosc2 + wartosc1); break;}
     case '-': {stos.push(wartosc2 - wartosc1); break;}
     case '/': {stos.push(wartosc2 / wartosc1); break;}
     case '%': {stos.push(wartosc2 % wartosc1); break;}
     case '#': {stos.push(Math.exp(Math.log(wartosc1))/wartosc2); break;}// pierwiastek wartosc2 -stopnia z warosc1
     case '^': {stos.push(Math.pow(wartosc2,wartosc1)); break;} 
     
    }
   }
  }
  return stos.pop();
 }

}