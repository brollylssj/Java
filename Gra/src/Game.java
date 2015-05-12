import java.util.HashMap;
import java.util.Scanner;

import com.tomaszhanusiak.opponent.Opponent;
import com.tomaszhanusiak.postac.Postac;
import com.tomaszhanusiak.postac.Poziom;
import com.tomaszhanusiak.walka.Fight;

/**
 * Klasa tworzaca nowa gre
 * @author Tomasz Hanusiak
 *
 */
public class Game {
	
	private HashMap<Integer, String> menuMap = new HashMap<>();
	
	public Game()
	{
		setMap();
	}
	public void setMap()
	{
		menuMap.put(1, "Podejmij walke");
		menuMap.put(2, "Fontanna zdrowia");
		menuMap.put(3, "Pokaz statystyki");
		menuMap.put(4, "Zakoncz");
	}
	
	/**
	 * Metoda wyswietlajaca podstawowe menu
	 */
	public void showMenu()
	{
		System.out.println("\nJaka akcje chcesz podj¹æ");
		for(int i = 1;i<menuMap.size()+1;i++)
		{
			System.out.println(i+" "+menuMap.get(i));
		}
	}
/**
 * Metoda pobierajaca od urzytkownika odpowiedz
 * @return zwraca int z menu którym chce korzystac
 */
	private int choiceUser()
	{
		boolean syntaxError=false;
		do{
			
			try {		
				syntaxError=false;
				Scanner scanner = new Scanner(System.in);
				int answer = scanner.nextInt();
				return answer;
		
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Wpisz 1,2,3...");
				syntaxError=true;
				return 0;
			}
			
			
		}while(syntaxError);
	}
	
	public void selectedMenu(Postac postac)
	{
		int key;
		do{
		
		showMenu();
		key= choiceUser();
		switch (key) {
		case 1:
			Opponent opponent = new Opponent();
			postac.checkListOfMonster(opponent);
			opponent = opponent.selectMonster();
			Fight fight = new Fight();
			fight.combat(postac, opponent);
			postac.getCurrentPoziom().chceckProgress(postac, fight, opponent);
			
			break;
			
		case 2:
			System.out.println("Odwiedziles fontanne zdrowia twoje zycie zostalo zregenerowane");
			postac.setHp(postac.getHpMax());
			break;
		case 3:
			System.out.println(postac);
			
			break;
		case 4:
			System.out.println("Zakonczyles gre");
			break;
			
		default:
			break;
		}
		
		
	}while(key!=4);
	}
	
	/**
	 * Metoda tworzaca postac
	 * @return obiekt klasy Postac
	 */
	public Postac createCharacter()
	{
		Postac postac = new Postac();
		postac = postac.selectProfession();
		postac.choseName();
		System.out.println(postac);
		return postac;
	}
}
