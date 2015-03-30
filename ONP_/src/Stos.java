
public class Stos 
{
	private String stos[];
	private Double stosDouble[];
	private int firstElement;
	private int firstElementDouble;

	 public Stos(int maxSize) {
	
		stos = new String[maxSize];
		firstElement =0;
	}
	 
	 
	 public Stos(int maxSize, String d) {
			stosDouble = new Double[maxSize];
			firstElementDouble =0;
		}


	boolean isEmpty() {
	        if (firstElement == 0) {
	            return true;
	        } else
	            return false;
	    }
	boolean isEmptyDouble() {
        if (firstElementDouble == 0) {
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
	System.out.println(stos[firstElement]);
	return stos[firstElement];
}


public Double lookAtTopDouble()
{
	System.out.println(stosDouble[firstElementDouble]);
	return stosDouble[firstElementDouble];
}



public	void pushDouble(double variable)
{
    if (firstElement < stosDouble.length) {
        stosDouble[firstElementDouble] = variable;
        firstElementDouble++;
    }
    else
    	throw new ArrayIndexOutOfBoundsException("przepelnienie stosu");
}


public double popDouble() 
{
	if (firstElementDouble <= 0) {
		throw new ArrayIndexOutOfBoundsException("Stos jest pusty, operacja nie powiod³a siê");
}

	Double temp = stosDouble[firstElementDouble - 1];
	firstElementDouble--;
	return temp;
}
	
}
