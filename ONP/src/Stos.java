
public class Stos 
{
	private String stos[];
	private double stosDouble[];
	private int top;
	private int topDouble;

	 public Stos(int maxSize) {
	
		stos = new String[maxSize];
		top =0;
	}
	  
	 public Stos(int maxSize, String d) {
			stosDouble = new double[maxSize];
			topDouble =0;
		}

	boolean isEmpty() {
	        if (top == 0) {
	            return true;
	        } else
	            return false;
	    }
		
public	void push(String variable)
	{
	stos[++top] = variable;
	}



public String pop() 
{
	return stos[top--];
}

public String lookAtTop()
{
	return stos[top];
}


public	void pushDouble(double variable)
{
	stosDouble[++topDouble] = variable;
}


public double popDouble() 
{
	return stosDouble[topDouble--];
}
	
}
