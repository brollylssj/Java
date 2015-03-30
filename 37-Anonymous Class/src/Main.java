
class Machine
{
	public void start()
	{
		System.out.println("Starting... Machine");
	}
}

interface Plant{
	public void grow();
}
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		
		
		Machine machine = new Machine(){

			@Override
			public void start() {
				// TODO Auto-generated method stub
				System.out.println("Snap Snap");
			}
			
		};
		
		machine.start();
	
		
		
		Plant plant = new Plant()
		{

			@Override
			public void grow() {
				System.out.println("Grow!");
				
			}
		};
		
		
		plant.grow();
		}
	}


