import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class Main2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			File file = new File("test.txt");
			

			
			try(BufferedReader buffer = new BufferedReader(new FileReader(file)))
			{
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

}
