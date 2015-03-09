
public class Stos 
{
	private String stos[];
	private double stosDouble[];
	private int firstElement;
	

	 public Stos(int maxSize) {
	
		stos = new String[maxSize];
		firstElement =0;
	}
	 
	 
	 public Stos(int maxSize, String d) {
			stosDouble = new double[maxSize];
			firstElement =0;
		}


	boolean isEmpty() {
	        if (firstElement == 0) {
	            return true;
	        } else
	            return false;
	    }
	
	
public	void push(String variable)
	{
        if (firstElement < stos.length) {
            stos[firstElement] = variable;
            firstElement++;
        }
        else
        	throw new ArrayIndexOutOfBoundsException("przepelnienie stosu");
	}


	
public String pop() 
{
	if (firstElement <= 0) {
        throw new ArrayIndexOutOfBoundsException("Stos jest pusty, operacja nie powiod³a siê");
    }

    String temp = stos[firstElement - 1];
    firstElement--;
    return temp;
}
	

public String lookAtTop()
{
	return stos[0];
}



public	void pushDouble(double variable)
{
    if (firstElement < stosDouble.length) {
        stosDouble[firstElement] = variable;
        firstElement++;
    }
    else
    	throw new ArrayIndexOutOfBoundsException("przepelnienie stosu");
}


public double popDouble() 
{
if (firstElement <= 0) {
    throw new ArrayIndexOutOfBoundsException("Stos jest pusty, operacja nie powiod³a siê");
}

double temp = stosDouble[firstElement - 1];
firstElement--;
return temp;
}
	
}
