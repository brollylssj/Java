
public class Samochod {
	private String marka;
	private int rokProdukcji;
	private int przebieg;
	private String color;
	private boolean sprowadzany = false;
	private boolean zepsuty = false;
	
	public Samochod(String marka, int rokProdukcji, int przebieg, String color) {
		// TODO Auto-generated constructor stub
		
		this.marka = marka;
		this.rokProdukcji = rokProdukcji;
		this.przebieg = przebieg;
		this.color = color;
		
	}
	
	
	public Samochod(String marka, int rokProdukcji, int przebieg, String color,boolean sprowadzany) {
		this.marka = marka;
		this.rokProdukcji = rokProdukcji;
		this.przebieg = przebieg;
		this.color = color;
		this.sprowadzany =sprowadzany = true;
	}
	
	
	
	public Samochod(String marka, int rokProdukcji)
	{
		this.marka = marka;
		this.rokProdukcji = rokProdukcji;
		this.zepsuty =true;
		
	}

	public String getMarka() {
		return marka;
	}

	public void setMarka(String marka) {
		this.marka = marka;
	}

	public int getRokProdukcji() {
		return rokProdukcji;
	}

	public void setRokProdukcji(int rokProdukcji) {
		this.rokProdukcji = rokProdukcji;
	}

	public int getPrzebieg() {
		return przebieg;
	}

	public void setPrzebieg(int przebieg) {
		this.przebieg = przebieg;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String toString() 
	{
		if(sprowadzany&& !zepsuty)
		{
			return "Samochod marki " + marka + ", o roku produkcji " + rokProdukcji
					+ ", z przebiegiem " + przebieg + ", o kolorze " + color +" sprowadzany";
		}
		if(!sprowadzany && !zepsuty)
		{
		return "Samochod marki " + marka + ", o roku produkcji " + rokProdukcji
				+ ", z przebiegiem " + przebieg + ", o kolorze " + color;
		}
		else 
			return "Samochod marki " + marka + ", o roku produkcji " + rokProdukcji +
						" przeznaczony do kasacji z powodu uszkodzen";
	}
	
	
	
	

}
