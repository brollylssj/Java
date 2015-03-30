import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;


public class Main {

	public static void main(String[] args) {
		
		File file = new File("new.txt");
		
		FileReader fr;
		try {
			fr = new FileReader(file);
		} catch (FileNotFoundException e) {
			System.out.println("Nie znaleziono pliku "+file.toString());
		}
		
		

	}

}
