package inheritance;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Machine mach = new Machine();
		
		mach.start();
		mach.stop();
		
		Car car = new Car();
		
		car.stop();
		car.start();
		car.wipeWindShild();
		car.showInfo();
		
		
	}

}
