import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * Klasa do wprowadzenia danych do konsoli
 * @author Tomasz Hanusiak
 *
 */
public class Input {
	
	
	private String expression,ONPexpression; // string wpisany i ONP
	private String notNumber ="+-*/^%sqrt()"; // wyrazenia ktore nie sa liczbami
	
	/**
	 * Funkcja odczytuje wprowadzone komendy z klawiatury
	 */
	public void read()
	{
		System.out.println("Wprowadz dzialanie: ");
		Scanner scanner = new Scanner(System.in);
		expression = scanner.nextLine();
	}
	
	public void check()
	{
		Stack<String> stos = new Stack<String>(); // utworzenie stosu
		StringTokenizer piece = new StringTokenizer(expression, "+-*/^%sqrt()", true); // StringTokenizer dzieli stringi na kawalki
		while (piece.hasMoreTokens()== true) // sprawdza czy istnieja jeszcze kawalki do pobrania
		{
			String next= piece.nextToken();
			if( next.equals("+") || next.equals("*") || next.equals("-") || next.equals("/") || next.equals("^") 
					             || next.equals("%") || next.equals("sqrt") );
			while(stos.empty() == true && priorytet(stos.peek()) >= priorytet(next))
			{
				ONPexpression = ONPexpression + stos.pop() + " "; // odaje 
			}
			
			stos.push(piece); // odkladam operator na stos
				
		}
	}

	private int priorytet(String next) {
		int result=0;
		if(next.equals("+") ||next.equals("-") )
			result= 1;
		if(next.equals("*") ||next.equals("/") )
			result= 2;
		if(next.equals("^") ||next.equals("sqrt") )
			result= 3;
		
		return result;
	}

}
