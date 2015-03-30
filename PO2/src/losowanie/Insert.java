package losowanie;

/*
 * @author Tomasz Hanusiak
 * Klasa odpowiedzialna za sortowanie przez wstawianie
 */
public class Insert {

	private  int array[];
	private  int size;

	/**
	 * Funkcja wykonuje sortowanie
	 * @param tablica tablica liczb do posortowania
	 * @param ile_liczb ilosc znakow w tablicy
	 */
	 void sortowanie(int tablica[], int ile_liczb) 
{
		int i, j, k;
		for (i = 1; i < ile_liczb; i++) 
		{
			j = i;
			k = tablica[i];

			while ((j > 0) && (tablica[j - 1] > k)) 
			{
				tablica[j] = tablica[j - 1];
				j--;
			}
			tablica[j] = k;
		}
		
	}
			
}
	
