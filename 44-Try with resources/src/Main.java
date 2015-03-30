
class Temp implements AutoCloseable
{

	@Override
	public void close() throws Exception {
		
		System.out.println("Closing");
		throw new Exception("oh no!");
	}
	
}
public class Main {

	public static void main(String[] args) {

//		Temp temp = new Temp();
//		try {
//			temp.close();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		try(Temp temp = new Temp())
		{
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
