import java.text.ParseException;


public class Overloading
{

	public void wypelnij(int pesel,int wiek)
	{
		System.out.println("Twoje dane to pesel" +pesel+"wiek " + wiek);
	}
	
	
	public void wypelnij(double srednia,int rok)
	{
		System.out.println("Twoja srednia "+ srednia +"rok studiow"+ rok);
	}
	
	public double srednia(double a,double b, double c,double d,double e)
	{
		return (a+b+c+d+e)/5;
	}
	
	public double srednia(double[] oceny,int ilosc)
	{
		double wynik = 0;
		for(int i = 0;i<ilosc;i++)
		{
			wynik+=oceny[i];
		}
		return wynik/ilosc;
		
	}

	public double srednia(String oceny)
	{
		Integer suma = 0;
		try {
			
			for(int i=0;i<oceny.length();i++)
			{
				suma = suma + Integer.parseInt(oceny.substring(i,i+1));
			}
			
			return (double)suma/oceny.length();
			
		} catch (NumberFormatException e) {
			System.out.println("Wprowadzone dane nie zawieraja tylko liczb");
			return 0;
		}
	
		
	}
	
	
	public void srednia(String[] people, String oceny)
	{
		for(int i =0;i<people.length;i++)
		{
			System.out.println(people[i]+"ma ocene na koniec "+ oceny.substring(i,i+1));
		}
	}
	

}
