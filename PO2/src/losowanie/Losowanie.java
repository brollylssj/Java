package losowanie;
import java.util.Random;

/**
 * 
 * @author Tomasz Hanusiak
 * Klasa wykonujaca losowanie
 */
public class Losowanie {
	
	final static int N =10;// ilosc losowanych liczb
	private String tab="aπbcÊdeÍfghijklmnoÛpqrstuvwxyzøüA•BC∆DEFGHIJKLMNOPQRSTU”VWXYZèØ"; // zmienna przechowujaca wszystkie znaki
	private int[] wyniki= new int[N]; // tablica do losowania liczb
	String[] wyrazy = new String[wyniki.length];  // tablica przechowujaca przechowywane liczby
	private String samogloski = "aπeÍoÛuyiA•E IOUY”"; //zmienna przechowujaca samogloski

	/**
	 * funkcja wypelnia tablice losowymi znakami
	 */
	void wypelnij()
	{
		Random random = new Random();
	
		int temp;
		for(int i= 0 ;i<wyniki.length;i++)
		{
			
				temp = random.nextInt(tab.length());
				wyniki[i]=temp;
		}
	}
	/**
	 * funkcja wyswietlajaca wyniki
	 */
	void show()
	{
		for(int i=0; i<wyrazy.length;i++)
			System.out.print(wyrazy[i]+ " ");
		
			
	}
	
	/**
	 * funkcja konwertujaca z inta na string
	 */
	void convert()
	{
		
		for (int i =0 ;i<wyniki.length;i++)
			wyrazy[i] = tab.substring(wyniki[i], wyniki[i]+1);
		
		show();
	}
	
	
/**
 * funkcja sortujaca	
 */
	void sortuj()
	{
		Insert insert = new Insert();
		insert.sortowanie(wyniki, wyniki.length);
		
	}
	
	/**
	 * Funkcja liczaca samogloski i spolgloski
	 */
	void licz()
	{
		int licznik = 0;
		for(int i=0; i<wyrazy.length;i++)
		{
			for(int j=0;j<samogloski.length();j++)
			{
				if(wyrazy[i].equals(samogloski.substring(j, j+1)))
				{
					licznik++;
				}
				
			}
			
			
		}
		
		System.out.println("\nLiczba samoglosek "+licznik);
		int spolgloski = wyniki.length - licznik;
		System.out.println("Liczba spolglosek "+spolgloski);
	}
	
}
