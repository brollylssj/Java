import java.util.Iterator;

/**
 * Klasa tworzy i wyswietla plansze po ktorej toczona jest rozgrywka
 * @author Brolly
 *
 */
public class Board 
{
		
private String[][] poleGry = new String[8][8];
	
	/**
	 * Metoda tworzy plansze do gry w szachy
	 */
	public void createBoard()
	{
		for (int i = 0; i < poleGry.length; i++) 
		{
			for (int j = 0; j < poleGry.length; j++) 
				poleGry[i][j]="0";
				
		}
	}
	
	/**
	 * Metoda Wyswietla plansze
	 */
	public void showBoard()
	{
		for (int i = 0; i < poleGry.length; i++) 
		{
			for (int j = 0; j < poleGry.length; j++)
				System.out.print(poleGry[i][j]);
			
				System.out.print("\n");
		}
		
	}

}
