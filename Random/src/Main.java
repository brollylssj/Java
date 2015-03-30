import java.util.Random;


public class Main {

	public static void main(String[] args) {
	
		Random random = new Random();
        int[] liczba = new int[10];
       
        	
        for (int j = 0; j < liczba.length; j++) {
			
              liczba[j] = random.nextInt(100);
              System.out.println(liczba[j]);
               
        }
              
        }
	}


