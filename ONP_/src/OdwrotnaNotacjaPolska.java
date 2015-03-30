
import java.util.*;  

public class OdwrotnaNotacjaPolska {
 // pola klasy
 private String wyrazenieInfiksowe;
 private String wyrazeniePostfiksowe; 
 private double wynik;   
 
 // konstruktor dokonuje przypisania polom wyra�e�
 public OdwrotnaNotacjaPolska(String wyrazenie) {
  this.wyrazenieInfiksowe = wyrazenie;
  wyrazeniePostfiksowe = "";
  wynik = 0.0;
  
   // wywo�ujemy metod� dokonuj�c� konwersji
   infiksNaPostfiks();
   wynik = oblicz();
  }   
 

 // metoda zwraca wyra�enie w formie infiksowej
 public String pobierzWyrazenieInfiksowe() {
  return wyrazenieInfiksowe;
 }

 // metoda zwraca wyra�enie w formie postfiksowej
 public String pobierzWyrazeniePostfiksowe() {
  return wyrazeniePostfiksowe;
 }
 
 // metoda zwraca obliczon� warto�� wyra�enia postfiksowego
 public double pobierzWynik() {
  return wynik;
 }
 
 

 // metoda konwertuje wyra�enie w postaci infiksowej na postfiksow�
 // wynik operacji jest zapisywany w polu wyrazeniePostfiksowe
 private void infiksNaPostfiks() {
        
  // tworzymy pusty stos
  //Stack<String> stos = new Stack<String>();
    Stos stos = new Stos(256);   
  // dzielimy wyra�enie infiksowe na cz�ci na podstawie separator�w
  StringTokenizer st = new StringTokenizer(wyrazenieInfiksowe, "+-*/()", true);
        
  // dop�ki s� elementy w wyra�eniu wej�ciowym
  while(st.hasMoreTokens()) {
   // pobieramy element
   String s = st.nextToken();
         
   // je�eli element jest operatorem
   if( s.equals("+") || s.equals("*") || s.equals("-") || s.equals("/")) {
    // sprawdzamy priorytety
    while(!stos.isEmpty() && priorytet(stos.lookAtTop()) >= priorytet(s)) 
     wyrazeniePostfiksowe += stos.pop()  + " ";
    // odk�adamy operator na stos
    stos.push(s);
   }
   // je�eli element jest nawiasem otwieraj�cym
   else if(s.equals("(")) stos.push(s);
   // je�eli element jest nawiasem zamykaj�cym
   else if(s.equals(")")) {
    // �ci�gamy operatory ze stosu, a� do nawiasu otwieraj�cego
    while(!stos.lookAtTop().equals("(")) wyrazeniePostfiksowe += stos.pop() + " ";
    // �ci�gamy nawias otwieraj�cy
    stos.pop();
   }
   // je�eli element nie jest operatorem ani nawiasem dodajemy go do wyra�enia postfiksowego
   else wyrazeniePostfiksowe += s  + " ";
  }
  // �ci�gamy ze stosu pozosta�e operatory i dodajemy je do wyra�enia postfiksowego
  while(!stos.isEmpty()) wyrazeniePostfiksowe += stos.pop()  + " ";
        
 } 
  
 // metoda zwraca priorytet operatora
 public static int priorytet(String operator) {
  // dla '+' i '-' zwracamy 1
  if(operator.equals("+") || operator.equals("-")) return 1;
  // dla '*' i '/' zwracamy 2
  else if(operator.equals("*") || operator.equals("/")) return 2;
  // dla pozosta�ych 0
  else return 0;
 }
 
 // metoda oblicza warto�� wyra�enia postfiksowego
 private double oblicz() {
  
  // tworzymy pusty stos
 // Stack<Double> stos = new Stack<Double>();
    Stos stos = new Stos(256,"Double"); 
  // dzielimy wyra�enie postfiksowe na elementy na podstawie spacji
  StringTokenizer st = new StringTokenizer(wyrazeniePostfiksowe, " ");
        
  // dop�ki s� elementy w wyra�eniu wej�ciowym
  while(st.hasMoreTokens()) {

   // pobieramy element
   String s = st.nextToken();
  
   // je�li element nie jest operatorem (czyli jest warto�ci�)
   if (!s.equals("+") && !s.equals("*") && !s.equals("-") && !s.equals("/")) {
    // zamieniamy �a�cuch na liczb�
    double wartosc = Double.parseDouble(s);
    // odk�adamy warto�� na stos
    stos.pushDouble(wartosc);
   }
   else {
    //  je�li element jest operatorem �ci�gamy dwie warto�ci ze stosu
    double wartosc1 = stos.popDouble();
    double wartosc2 = stos.popDouble();
    // w zale�no�ci od operatora obliczamy wynik i odk�adamy go na stos
    switch(s.charAt(0)) {
     case '*': {stos.pushDouble(wartosc2 * wartosc1); break;}
     case '+': {stos.pushDouble(wartosc2 + wartosc1); break;}
     case '-': {stos.pushDouble(wartosc2 - wartosc1); break;}
     case '/': {stos.pushDouble(wartosc2 / wartosc1); break;}
    }
   }
  }
  // zwracamy ko�cowy wynik
  return stos.popDouble();
 }
 
 // metoda zwraca nam �a�cuch tekstowy z wyra�eniem 
 // w formie postfiksowej, oraz wynik
 public String toString() {
  return wyrazeniePostfiksowe + "\nWynik: " + wynik;
 }
}