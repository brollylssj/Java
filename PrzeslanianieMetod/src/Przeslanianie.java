
class A
{
	void callme()
	{
	System.out.println(" Metoda callme() clasy A");
	}
}
class B extends A
{
	void callme()// przeslonieniecie z A callme
	{
		System.out.println(" Metoda callme() clasy B ");
	}
}	
	class C extends A
	{	
		void callme()
		{
			System.out.println(" Metoda callme() clasy C");
		}
		
	}

public class Przeslanianie{
	public static void main(String[] args)
	{

		A a = new A();// obiekt klasy A
		B b = new B();
		C c = new C();
		A r ; // moze przechowywac referencje do typu A;
		
		r=a; // r odnosi sie do obiektu A
		
		r.callme(); // wywolaj calme z A
		
		r= b; // r odnosi sie do B
		r.callme(); // z B
		
		r=c;
		r.callme(); // z C
	}

}


