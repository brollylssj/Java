
public class Rownanie {
	
	private int a,b,c;
	String rozwiazanie;

	Rownanie(int a,int b,int c)
	{
		this.a = a;
		this.b = b;
		this.c = c;
		
	}
	
	public String make()
	{
		double delta;
		
		
		
		delta = b*b-4*a*c;
		
		if (delta >0)
		{
			delta = Math.sqrt(delta);
		
		double x1 = (-b-delta)/(2*a);
		double x2 = (-b+delta)/(2*a);
		
		rozwiazanie ="x1:"+x1+" x2:"+x2;
		}
		
		else if (delta == 0)
		{
			double x0 = -b/(2*a);
			rozwiazanie ="x0:"+x0;
		}
		
		else
			rozwiazanie ="Brak";
		
		return rozwiazanie;
	}
	
}
