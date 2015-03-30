package Main;

import java.util.ArrayList;
import java.util.Iterator;

class Machine
{

	@Override
	public String toString() {
		return "I am a machine";
	}

	
	
	public void start()
	{
		System.out.println("Machine starting!");
	}

	
}

class Camera extends Machine
{

	@Override
	public String toString() {
		return "I am Camera";
	}
	public void start()
	{
		System.out.println("Camera snap!");
	}
}

public class Main {

	public static void main(String[] args) {


		
		ArrayList<Machine> list1 = new ArrayList<Machine>();
		
		list1.add(new Machine());
		list1.add(new Machine());
		showList(list1);
		
		
		
ArrayList<Machine> list2 = new ArrayList<Machine>();
		
		list2.add(new Camera());
		list2.add(new Camera());
		showList(list2);

	}
	
	public static void showList(ArrayList<? extends Machine> list)
	{
		for (Machine object : list) {
			System.out.println(object);
			object.start();
		}
			
		
	}

}
