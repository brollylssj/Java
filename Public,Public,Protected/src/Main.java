import world.Plant;

/* private tylko w tej samej klasie
 * public wszedzie
 * protected ta sama klasa sublklasa i package
 * no modifire tylko package
 */
public class Main {

	public static void main(String[] args) {
			
		
		Plant plant = new Plant();
		
		System.out.println(plant.name);
		System.out.println(plant.ID);
	//	System.out.println(plant.size);
	}

}
