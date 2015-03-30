import java.util.Scanner;


public class App {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	
		
		Animal animal = Animal.CAT;
		


		
		
		switch(animal)
		{
		case CAT:
			System.out.println("CaT");
			break;
		case DOG:
			System.out.println("DOg");
			break;
		case MOUSE:
			System.out.println("Mouse");
			break;
		default:
			break;
		
		}
		
		
		System.out.println(Animal.MOUSE.getName());
	}

}
