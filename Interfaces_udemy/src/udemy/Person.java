package udemy;

public class Person implements Info {
	
	private String name;

	public Person(String name) {
		this.name = name;
	}
	
	
	public void greet()
	{
		System.out.println("Hello there");
	}


	@Override
	public void ShowInfo() {


		System.out.println("Person name is"+ name);
		
	}
	
	

}
