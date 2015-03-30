
import java.util.*;  

public class OdwrotnaNotacjaPolska {
 // pola klasy
 private String wyrazenieInfiksowe;
 private String wyrazeniePostfiksowe; 
 private double wynik;   
 
 // konstruktor dokonuje przypisania polom wyra¿eñ
 public OdwrotnaNotacjaPolska(String wyrazenie) {
  this.wyrazenieInfiksowe = wyrazenie;
  wyrazeniePostfiksowe = "";
  wynik = 0.0;
  
   // wywo³ujemy metodê dokonuj¹c¹ konwersji
   infiksNaPostfiks();
   wynik = oblicz();
  }   
 

 // metoda zwraca wyra¿enie w formie infiksowej
 public String pobierzWyrazenieInfiksowe() {
  return wyrazenieInfiksowe;
 }

 // metoda zwraca wyra¿enie w formie postfiksowej
 public String pobierzWyrazeniePostfiksowe() {
  return wyrazeniePostfiksowe;
 }
 
 // metoda zwraca obliczon¹ wartoœæ wyra¿enia postfiksowego
 public double pobierzWynik() {
  return wynik;
 }
 
 

 // metoda konwertuje wyra¿enie w postaci infiksowej na postfiksow¹
 // wynik operacji jest zapisywany w polu wyrazeniePostfiksowe
 private void infiksNaPostfiks() {
        
  // tworzymy pusty stos
  //Stack<String> stos = new Stack<String>();
    Stos stos = new Stos(256);   
  // dzielimy wyra¿enie infiksowe na czêœci na podstawie separatorów
  StringTokenizer st = new StringTokenizer(wyrazenieInfiksowe, "+-*/()", true);
        
  // dopóki s¹ elementy w wyra¿eniu wejœciowym
  while(st.hasMoreTokens()) {
   // pobieramy element
   String s = st.nextToken();
         
   // je¿eli element jest operatorem
   if( s.equals("+") || s.equals("*") || s.equals("-") || s.equals("/")) {
    // sprawdzamy priorytety
    while(!stos.isEmpty() && priorytet(stos.lookAtTop()) >= priorytet(s)) 
     wyrazeniePostfiksowe += stos.pop()  + " ";
    // odk³adamy operator na stos
    stos.push(s);
   }
   // je¿eli element jest nawiasem otwieraj¹cym
   else if(s.equals("(")) stos.push(s);
   // je¿eli element jest nawiasem zamykaj¹cym
   else if(s.equals(")")) {
    // œci¹gamy operatory ze stosu, a¿ do nawiasu otwierajêcego
    while(!stos.lookAtTop().equals("(")) wyrazeniePostfiksowe += stos.pop() + " ";
    // œci¹gamy nawias otwieraj¹cy
    stos.pop();
   }
   // je¿eli element nie jest operatorem ani nawiasem dodajemy go do wyra¿enia postfiksowego
   else wyrazeniePostfiksowe += s  + " ";
  }
  // œci¹gamy ze stosu pozosta³e operatory i dodajemy je do wyra¿enia postfiksowego
  while(!stos.isEmpty()) wyrazeniePostfiksowe += stos.pop()  + " ";
        
 } 
  
 // metoda zwraca priorytet operatora
 public static int priorytet(String operator) {
  // dla '+' i '-' zwracamy 1
  if(operator.equals("+") || operator.equals("-")) return 1;
  // dla '*' i '/' zwracamy 2
  else if(operator.equals("*") || operator.equals("/")) return 2;
  // dla pozosta³ych 0
  else return 0;
 }
 
 // metoda oblicza wartoœæ wyra¿enia postfiksowego
 private double oblicz() {
  
  // tworzymy pusty stos
 // Stack<Double> stos = new Stack<Double>();
    Stos stos = new Stos(256,"Double"); 
  // dzielimy wyra¿enie postfiksowe na elementy na podstawie spacji
  StringTokenizer st = new StringTokenizer(wyrazeniePostfiksowe, " ");
        
  // dopóki s¹ elementy w wyra¿eniu wejœciowym
  while(st.hasMoreTokens()) {

   // pobieramy element
   String s = st.nextToken();
  
   // jeœli element nie jest operatorem (czyli jest wartoœci¹)
   if (!s.equals("+") && !s.equals("*") && !s.equals("-") && !s.equals("/")) {
    // zamieniamy ³añcuch na liczbê
    double wartosc = Double.parseDouble(s);
    // odk³adamy wartoœæ na stos
    stos.pushDouble(wartosc);
   }
   else {
    //  jeœli element jest operatorem œci¹gamy dwie wartoœci ze stosu
    double wartosc1 = stos.popDouble();
    double wartosc2 = stos.popDouble();
    // w zale¿noœci od operatora obliczamy wynik i odk³adamy go na stos
    switch(s.charAt(0)) {
     case '*': {stos.pushDouble(wartosc2 * wartosc1); break;}
     case '+': {stos.pushDouble(wartosc2 + wartosc1); break;}
     case '-': {stos.pushDouble(wartosc2 - wartosc1); break;}
     case '/': {stos.pushDouble(wartosc2 / wartosc1); break;}
    }
   }
  }
  // zwracamy koñcowy wynik
  return stos.popDouble();
 }
 
 // metoda zwraca nam ³añcuch tekstowy z wyra¿eniem 
 // w formie postfiksowej, oraz wynik
 public String toString() {
  return wyrazeniePostfiksowe + "\nWynik: " + wynik;
 }
}