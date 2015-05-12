
public class Klient {
	private String imie;
	private String nazwisko;
	private int pesel;
	
	public Klient(String imie, String nazwisko, int pesel) {
		// TODO Auto-generated constructor stub
		
		this.imie = imie;
		this.nazwisko = nazwisko;
		this.pesel = pesel;
		
	}

	@Override
	public String toString() {
		return "Klient o imieniu " + imie + " nazwisko " + nazwisko + ", o peselu "
				+ pesel;
	}
	
	
	void wypozyc(Samochod samochod,Wypozyczalnia wypozyczalnia)
	{
		System.out.println(samochod+" " + wypozyczalnia);
	}
	
	
	
	

}
