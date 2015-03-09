
public class Stos 
{
	private String stos[];
	private int firstElement;
	

	 public Stos(int maxSize) {
		stos = new String[maxSize];
		firstElement =0;
	}


	boolean isEmpty() {
	        if (firstElement == 0) {
	            return true;
	        } else
	            return false;
	    }
	
	
public	void push(String variable) throws Exception 
	{
        if (firstElement < stos.length) {
            stos[firstElement] = variable;
            firstElement++;
        }
        else
        	throw new Exception("przepelnienie stosu");
	}
	
public String pop() throws Exception
{
	if (firstElement <= 0) {
        throw new Exception("Stos jest pusty, operacja nie powiod³a siê");
    }

    String temp = stos[firstElement - 1];
    firstElement--;
    return temp;
}
	

public String lookAtTop()
{
	return stos[0];
}
	
}
