
public class Robot {
	
	private int id;
	
	// nested klasy zagniezdzone moga korzystac z zmiennych prywatnych
	 private class Brain
	{
		public void think()
		{
			System.out.println("Robot "+id+"is thinking");
		}
	}
	 
	 static class Battery
	 {
		 public void charge(){
			 System.out.println("battery charging ===");
		 }
	 }

	public Robot(int id) 
	{
		this.id = id;
	}
	
	public void start()
	{
		System.out.println("Starting Robot"+id);
		Brain brain = new Brain();
		brain.think();
		
		final String name = "Tomek";
		class Temp
		{
			public void doSomething()
			{
				System.out.println("Id is "+id);
				System.out.println("My name is"+name);
			}
		}
		
		Temp temp = new Temp();
		temp.doSomething();
	}

}
