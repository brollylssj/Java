/**
 * Klasa reprezentujaca stos
 * @author Tomasz Hanusiak
 *
 */
public class StosString 
{
	private String stos[]; // stos przechowujacy string
	private int top;	// wierzecholek stosu string


/**
 * Konstruktor stosu string
 * @param maxSize wielkosc stosu
 */
public StosString(int maxSize) 
{
	stos = new String[maxSize];
	top =0;
}

/**
 * Metoda zwracajaca czy stos jest pusty
 * @return true gdy stos jest pusty false gdy nie
 */
boolean isEmpty() 
{
	        if (top == 0) 
	            return true;
	         else
	            return false;
}
/**
 * Metoda dodaje element na stos
 * @param variable dodawana wartosc na stos
 */
public	void push(String variable)
	{
	stos[++top] = variable;
	}


/**
 * Metoda sciaga ze stosu liczbe
 * @return sciagany element ze stosu
 */
public String pop() 
{
	
	return stos[top--];
}
/**
 * Metoda zwraca wierzcholek
 * @return zwraca wierzcholek
 */
public String lookAtTop()
{
	return stos[top];
}

	
}
