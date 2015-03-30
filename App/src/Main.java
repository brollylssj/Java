class Frog
{
	private String name;
	private int age;
	
	public String name1;
	private int id;
	
	public Frog(int id,String name)
	{
		this.id = id;
		this.name1= name1;
	}

	public String toString()
	{
		return "hello";
	}
	public String getName()
	{
		return name;
	}
	
	public int getAge()
	
	{
		return age;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	
	
}


public class Main {

	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Frog frog1 = new Frog();
	//	frog1.name = "Ala";
	//	frog1.age = 1;
		
		System.out.println(frog1);
		
	Frog frog2 = new Frog();
		frog2.setAge(2);
		frog2.setName("Ola");
	}
	
	

}
