
abstract class Figura {
	
	double dim1;
	double dim2;
	Figura(double a, double b)
	{
		dim1=a;
		dim2=b;
	}

	abstract double pole();
//	{
//		System.out.println("Pole niezdefiniowane");
//		return 0;
//	}
}

class Reactangle extends Figura
{
	Reactangle (double a,double b)
	{
		super(a,b);
	}

double pole()
{
	return dim1*dim2;
}
}

class FindPole{
	public static void main(String[] args) {
		
	//Figura f = new Figura(10,10); - gdy stworze abstarct nie moge utworzyc obiektu
	Reactangle r = new Reactangle(10,20);
	
	Figura zaslon;
	
	//zaslon = f;
	//System.out.println("pole wynosi"+zaslon.pole());
	
	zaslon = r ;
	System.out.println("pole wynosi"+zaslon.pole());

	}

}
