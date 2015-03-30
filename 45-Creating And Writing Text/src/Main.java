import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class Main {

	public static void main(String[] args) {
		
		File file = new File ("text.txt");
		
		try(BufferedWriter writer = new BufferedWriter(new FileWriter(file)))
		{
			writer.write("This is line one\n");
			writer.write("This is line two\n");
			writer.write("This is three");
			writer.newLine();
			writer.write("last line");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Nie utworzono pliku "+ file.toString());
		}
	}

}
