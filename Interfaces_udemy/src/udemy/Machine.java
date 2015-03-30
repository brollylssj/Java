package udemy;

public class Machine implements Info{
	
	private int id = 7;
	public void start()
	{
		System.out.println("Machine started");
	}
	@Override
	public void ShowInfo() {
		
		System.out.println("Machine Id is"+id);
	}
	
	
}
