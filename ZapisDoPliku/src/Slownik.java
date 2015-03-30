import java.awt.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;
import java.util.TreeMap;


public class Slownik 
{
	protected String[] wyraz;
	protected String[] wyniki;
	protected Integer []counter;
	protected TreeMap<String, Integer> tree;
	
	Slownik()
	{
		wyraz = new String[]  {"red","blue","java","car","blue","bike","flower","bucket","yellow","pink"};
		counter = new Integer[wyraz.length];
		wyniki = new String[1000];
		tree= new TreeMap<String, Integer>();
	}


	protected void create()
	{
		Random random = new Random();
		int indeks;
		
		for(int i =0;i<wyraz.length;i++)
			counter[i]=1;
		
		for(int i =0;i<wyniki.length;i++)
		{
			indeks = random.nextInt(wyraz.length);
			wyniki[i]=wyraz[indeks];
				
			for(int j =0;j<wyraz.length;j++)
			{
			if(wyniki[i].equals(wyraz[j]))
						counter[j]+=1;
					
			}
		}
		
		
			
	}
	
	
	protected void merge()
	{

		 for(int i =0;i<10;i++)
			 tree.put(wyraz[i],counter[i]);
		 
		 System.out.println(tree);
		 
	}
}


