import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
	
		//String fileName ="I:/Java/Workspace_E/38-Reading Files/example.txt";
		String fileName ="1.txt";
		File textFile = new File(fileName);
		
		try {
			Scanner in = new Scanner(textFile);
			
			// wczytaj caly tekst
//			while(in.hasNextLine())
//			{
//				String line = in.nextLine();
//				System.out.println(line);
//			}
//			
			// wczytanie 3 linijek z tekstu
			int temp = in.nextInt();
			System.out.println("wczytano "+temp);
			// pomija pusta linijke;D
			in.nextLine();
			
			for(int i = 0;i<temp;i++)
			{
				String line = in.nextLine();
				System.out.println(line);
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Nie ma tego pliku");
		}
		
		

	}

}
