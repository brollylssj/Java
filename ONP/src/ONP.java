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
        
  // tworzymy pusty stos
  Stos stos = new Stos(256);
        
  // dzielimy wyra�enie na cz�ci na podstawie +-*/()#%^
  StringTokenizer piece = new StringTokenizer(input, "+-*/()#%^", true);
        
  // dop�ki s� elementy w wyra�eniu wej�ciowym
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
   // je�eli element nie jest operatorem ani nawiasem dodajemy go do wyra�enia postfiksowego
   else expression += nextCharacter  + " ";
  }
  // �ci�gamy ze stosu pozosta�e operatory i dodajemy je do wyra�enia postfiksowego
  while(!stos.isEmpty()) expression += stos.pop()  + " ";
        
 } 

/**
 * 
 * 
 */
 // metoda oblicza warto�� wyra�enia postfiksowego
 private double oblicz() {
  
  // tworzymy pusty stos
  Stack<Double> stos = new Stack<Double>();
        
  // dzielimy wyra�enie postfiksowe na elementy na podstawie spacji
  StringTokenizer st = new StringTokenizer(expression, " ");
        
  // dop�ki s� elementy w wyra�eniu wej�ciowym
  while(st.hasMoreTokens()) {

   // pobieramy element
   String s = st.nextToken();
  
   // je�li element nie jest operatorem (czyli jest warto�ci�)
   if (!s.equals("+") && !s.equals("*") && !s.equals("-") && !s.equals("/") && !s.equals("%")&& !s.equals("^") && !s.equals("#") ) {
    // zamieniamy �a�cuch na liczb�
    double wartosc = Double.parseDouble(s);
    // odk�adamy warto�� na stos
    stos.push(wartosc);
   }
   else 
   {
    //  je�li element jest operatorem �ci�gamy dwie warto�ci ze stosu
    double wartosc1 = stos.pop();
    double wartosc2 = stos.pop();
    // w zale�no�ci od operatora obliczamy wynik i odk�adamy go na stos
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