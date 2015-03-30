import java.util.Scanner;


public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		Scanner input = new Scanner(System.in);	
		int variable = input.nextInt();
		
		System.out.println("Silnia z "+variable+"wynosi: "+calculate(variable));
		
	}
	
	private static int calculate(int value)
	{
		
		if(value==1)
		{
			return 1;
		}
			return calculate(value-1)*value;
		
		
	}

}
