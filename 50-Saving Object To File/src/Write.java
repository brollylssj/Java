import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;


public class Write {

	public static void main(String[] args) {

		System.out.println("writing..");
		Person mike = new Person(123,"MIke");
		Person sue = new Person(332,"Sue");
		
		System.out.println(mike);
		System.out.println(sue);
		
		
		try(FileOutputStream fs = new FileOutputStream("pepople.bin"))
		{
			ObjectOutputStream os = new ObjectOutputStream(fs);
			
			os.writeObject(mike);
			os.writeObject(sue);
			
				
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
