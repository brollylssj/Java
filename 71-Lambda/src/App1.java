// 18 min

interface Executable1
{
	int execute(int a);
}
class Runner1
{
	public void run(Executable1 e)
	{
		System.out.println("Executing bolock... ");
		int value =e.execute(12);
		System.out.println("Return value is "+value);
	}
}
public class App1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Runner1 runner = new Runner1();
		runner.run(new Executable1() {
			
			@Override
			public int execute(int a) {
				// TODO Auto-generated method stub
				System.out.println("Java 6");
				return 7+a;
			}
		});
		
		System.out.println("--------------------");
		System.out.println("LAMbDA! 8");
		
		runner.run((int a )-> 2332141);
		runner.run((int a)->
		{
			System.out.println("THIS IS FCK!");
			System.out.println("LAMBDA!");
			return 9+a;
		});

	}

}
