import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		File file = new File("dupa.txt");
		
		try {
			FileReader reader = new FileReader(file);
			
			BufferedReader buffer = new BufferedReader(reader);
			
			String line;
			
			line = buffer.readLine();
			
			System.out.print(line);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("NIe znaleziono pliku "+file.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Nie mozna odczytac pliku"+file.toString());
		}
		
	}

}
