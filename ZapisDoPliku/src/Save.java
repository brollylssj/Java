import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class Save extends Slownik implements FileSave
{	
	protected File file;
	
	
	@Override
	public void save()
	{

	
	file = new File ("wyniki.txt");
	{
	
		try(BufferedWriter writer = new BufferedWriter(new FileWriter(file)))
		{
			for(int i =0;i<wyniki.length;i++)
			{
				writer.write(wyniki[i]+"\n");
			}
		
		} catch (IOException e) 
		{
		// TODO Auto-generated catch block
		System.out.println("Nie utworzono pliku "+ file.toString());
		}
		
	}
	

	}
}
