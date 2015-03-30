
public class App {

	public static void main(String[] args) {
		
		
		Slownik slownik = new Slownik();
		slownik.create();
		
		Save s= new Save();
		s.save();
		
		slownik.merge();
		
		CreateNew cNew =new CreateNew();
		cNew.save();


	}

}
