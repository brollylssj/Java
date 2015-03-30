package udemy;

public class Main {

	public static void main(String[] args) {


		Machine machine = new Machine();
		
		machine.start();
		
		Person person = new Person("Bob");
		
		person.greet(); 
		
		Info info1 = new Machine();
		info1.ShowInfo();
		
		Info info2  = person;
		info2.ShowInfo();
		
		
		outputinfo(machine);
		outputinfo(person);

	}

	
	private static void outputinfo(Info info)
	{
		
		info.ShowInfo();
		
	}
}
