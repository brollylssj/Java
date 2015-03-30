interface Executable
{
	void execute();
}
class Runner
{
	public void run(Executable e)
	{
		System.out.println("Executing bolock... ");
		e.execute();
	}
}
public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Runner runner = new Runner();
		runner.run(new Executable() {
			
			@Override
			public void execute() {
				// TODO Auto-generated method stub
				System.out.println("Java 6");
			}
		});
		
		System.out.println("--------------------");
		System.out.println("LAMbDA! 8");
		
		runner.run(()-> System.out.println("To je lamda"));
		
		runner.run(()->
		{
			System.out.println("THIS IS FCK!");
			System.out.println("LAMBDA!");
		});

	}

}
