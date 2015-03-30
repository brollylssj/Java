import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;




public class CreateNew extends Save implements FileSave
{

	
	
	@Override
	public void save() 
	{
		file = new File ("wyniki2.txt");
		{
		
			try(BufferedWriter writer = new BufferedWriter(new FileWriter(file)))
			{
				for(Map.Entry<String, Integer> entry :tree.entrySet())
				{
					String key =entry.getKey();
					Integer value = entry.getValue();
					
					writer.write(key+"="+value+"\n");
					
					
				}
			
			} catch (IOException e) 
			{
			// TODO Auto-generated catch block
			System.out.println("Nie utworzono pliku "+ file.toString());
			}
			
		}
	}
	
	
}
