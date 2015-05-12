
public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Wypozyczalnia wypozyczalnia = new Wypozyczalnia("1994-05-15", 3, true);
		//System.out.println(wypozyczalnia);
		
		Samochod samochod = new Samochod("Audi", 1990, 232214, "Niebieski");
		//System.out.println(samochod);
		
		Samochod samochod1 = new Samochod("Opel", 1994, 3214, "Zielony",true);
		//System.out.println(samochod1);
		
		
		//System.out.println(new Samochod("BMW", 2004));
		

		Klient klient = new Klient("Jan","Mazurek", 942332432);
		System.out.println(klient);
		
		klient.wypozyc(samochod,wypozyczalnia);

		
	}

}
