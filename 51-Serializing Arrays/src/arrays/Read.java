package arrays;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;


public class Read {

	public static void main(String[] args) {
		
		System.out.println("Reading...");
		
		try(FileInputStream fi = new FileInputStream("pepople.txt"))
		{
			ObjectInputStream os = new ObjectInputStream(fi);
			
			Person[] people = (Person[])os.readObject();
			
			ArrayList<Person> peopleList = (ArrayList<Person>)os.readObject();
			
			
			
			for (Person person : people) {
				System.out.println(person);
			}
			
			
			for (Person person : peopleList) {
				System.out.println(person);
			}
			
			os.close();

			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		
		

	}

}
