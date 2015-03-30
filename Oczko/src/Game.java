import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
/**
 * Class Game create Black Jack
 * @author Brolly
 *
 */
public class Game extends Karty {
	
	private int score;
	private int scoreNPC;
	private String answer;
	
	/**
	 * Methods draw cards.
	 */
	private void draw()
	{
		
		do
		{
			Random rand = new Random();
			System.out.println("Czy chcesz dobrac karte T/N");
			Scanner scan = new Scanner(System.in);
			answer =scan.nextLine();
			
			if(answer.equalsIgnoreCase("T"))
			{
				List<Integer> valuesList = new ArrayList<Integer>(map.values());
				List<String>  stringList = new ArrayList<String>(map.keySet());
				int randomIndex = rand.nextInt(valuesList.size());
				Integer randomValue = valuesList.get(randomIndex);
				
				System.out.println("Wylosowano Karte "+stringList.get(randomIndex));
				score = score + randomValue;
				map.remove(stringList.get(randomIndex));
				//System.out.println(map.size());
				System.out.println("Suma twoich kart wynosi : "+score);
			}
			
		}while(!answer.equalsIgnoreCase("N") && score<=21);
			pass();
		
	}
	
	/**
	 * Round NPC
	 */
	private void pass()
	{

		Random rand = new Random();
		System.out.println("Runda NPC");
		do
		{
			List<Integer> valuesList = new ArrayList<Integer>(map.values());
			List<String>  stringList = new ArrayList<String>(map.keySet());
			int randomIndex = rand.nextInt(valuesList.size());
			Integer randomValue = valuesList.get(randomIndex);
			
			System.out.println("Wylosowano Karte "+stringList.get(randomIndex));
			scoreNPC = scoreNPC + randomValue;
			map.remove(stringList.get(randomIndex));
			//System.out.println(map.size());
			System.out.println("Suma krupiera wynosi : "+scoreNPC);
			
		}while(scoreNPC <= score && score<=21);
		
		
		checkWinner();
	}
	
	/**
	 * Method check the winner of game 
	 */
	private void checkWinner()
	{

		if(score == scoreNPC)
		System.out.println("Remis");
		
		else if( score>scoreNPC && score<=21 && scoreNPC <=21)
			System.out.println("Wygrales");
		else if(score<scoreNPC)
		{
			if(scoreNPC>21)
				System.out.println("Wygrales");
			else if(score>21)
				System.out.println("Przegrales");
			else
				System.out.println("Przegrales");
		}
		else 
			System.out.println("Przegrales");
	
	}
	/**
	 * method check condition of exit game 
	 * @return
	 */
	private boolean quit()
	{	
		boolean end=false;
		if(answer.equalsIgnoreCase("Q"))
			end=true;
		return end;
	}
	
	
	/**
	 * Create new Game
	 */
	protected void newGame()
	{
		
		do{
			score =0;
			scoreNPC =0;
			System.out.println("Poczatek gry...");
			System.out.println("Tasowanie");
			shuffle();
			draw();
			System.out.println("Kliknij Q by zakonczyc");
			Scanner scan = new Scanner(System.in);
			answer= scan.nextLine();
		}while(!quit());
		
		
	}



}
