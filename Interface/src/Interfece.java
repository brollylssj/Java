import java.util.Scanner;

interface Callback
{
	void callback(int parametr);
}

class Client implements Callback
{
	public void callback(int p)
	{
		System.out.println("P  wynos"+p);
	}
}

class Client1 implements Callback
{
	public void callback(int p)
	{
		System.out.println("P do kawadratu wynos"+p*p);
	}
}

public class Interfece {

	public static void main(String[] args) {
		Callback c= new Client();
		Client1 object = new Client1();
		Scanner input = new Scanner(System.in);
		System.out.println("podaj zmienna interfacu");
		int podane = input.nextInt();
		
		c.callback(podane);

		
		c=object;
		
		// C teraz odnosi sie do obiektu Client3
		
		c.callback(podane);
	}

}
