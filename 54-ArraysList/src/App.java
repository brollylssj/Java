import java.util.ArrayList;
import java.util.List;


public class App {

	public static void main(String[] args) {
		
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		
		//adding	
		numbers.add(10);
		numbers.add(14);
		numbers.add(343);
		numbers.add(102);
		//retriving
		System.out.println(numbers.get(0));
		
		for (Integer integer : numbers) {
			
			System.out.println(integer);
		}
		
		
		for (int i = 0; i < numbers.size(); i++) {
			System.out.println(numbers.get(i));
		}
		
		
		// list interface
		
		List<String> value = new ArrayList<String>();		
		
	}

}
