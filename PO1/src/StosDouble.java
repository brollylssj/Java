
public class StosDouble {
	
	private double stosDouble[]; // stos przechowujacy double
	private int topDouble; // wierzcho³ek stosu double
	
	/**
	 * Konstruktor stosu
	 * @param maxSize wielkosc stosu
	 */
	public StosDouble(int maxSize) 
	{
		stosDouble = new double[maxSize];
		topDouble =0;
	}
	
	/**
	 * Metoda dodaje element na stos
	 * @param variable dodawana wartosc na stos
	 */
	public	void pushDouble(double variable)
	{
		stosDouble[++topDouble] = variable;
	}

/**
 * Metoda sciaga ze stosu liczbe
 * @return sciagany element ze stosu
 */
	public double popDouble() 
	{
		return stosDouble[topDouble--];
	}

}
