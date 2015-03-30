
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;


public class Write {

	public static void main(String[] args) {

		Person [] people ={ new Person(11, "Sue"), new Person(19, "John"),new Person(99, "Bob")};
		
		
		try(FileOutputStream fs = new FileOutputStream("pepople.txt"))
		{
			ObjectOutputStream os = new ObjectOutputStream(fs);
			
			Person.setCount(99);
			os.writeObject(people);
			
						
			os.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		

	}

}
