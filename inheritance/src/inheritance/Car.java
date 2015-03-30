package inheritance;

public class Car extends Machine{
	
	
	
	public void start()
	{
	String start = "car Started";
	System.out.println(start);
	}

	public void wipeWindShild()
	{
		System.out.println("Wiping windshild");
	}
	
	
	public void showInfo()
	{
		System.out.println("Car name"+name);
	}

}
