
public class Wypozyczalnia {
	
	private String data;
	private int dni;
	private boolean ubezpiecznie;
	
	
	public Wypozyczalnia(String data,int dni,boolean ubezpiecznie) {
		// TODO Auto-generated constructor stub
		this.data = data;
		this.dni = dni;
		this.ubezpiecznie = ubezpiecznie;	
	}


	public String getData() {
		return data;
	}


	public void setData(String data) {
		this.data = data;
	}


	public int getDni() {
		return dni;
	}


	public void setDni(int dni) {
		this.dni = dni;
	}


	public boolean isUbezpiecznie() {
		return ubezpiecznie;
	}


	public void setUbezpiecznie(boolean ubezpiecznie) {
		this.ubezpiecznie = ubezpiecznie;
	}
	
	
	public String ubezpiecz()
	{
		if(ubezpiecznie)
			return " z ubezpieczeniem";
		else 
			return " bez ubezpiecznia";
	}
	
	public String toString()
	{
		return "Wypozyczony samochod od " + data +" przez "+ dni+" dni"+ ubezpiecz();
	}

	
}
